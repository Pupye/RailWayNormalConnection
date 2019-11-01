package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.RouteEntity;
import com.sedbproj.Railways.Repositories.RouteRepository;
import com.sedbproj.Railways.Repositories.StationRepository;
import com.sedbproj.Railways.Wrappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

//TODO refactor this class
//route is created automatically
//we should have functionality to update route
//route should have name?? then just click on that we get stations
//here should update happen
//join table should have fk_train
@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StationRepository stationRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/search",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RouteWrapperGet getAll(@RequestBody SearchGet search){

        Timestamp dateStart = null;
        Timestamp dateEnd = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date paredDate = dateFormat.parse(search.getDate()+" 00:00:00");
            Date paredDate1 = dateFormat.parse(search.getDate()+" 23:59:59");
            dateStart = new java.sql.Timestamp(paredDate.getTime());
            dateEnd = new java.sql.Timestamp(paredDate1.getTime());
        }catch (Exception e){}

        List<RouteEntity> routeEntitiesDep = routeRepository.findRouteEntitiesByDepDateBetweenAndStationId(dateStart, dateEnd, search.getArrivalStationId());

        Set<Integer> routeIds = new HashSet<>();
        List<StationWrapperGet> wrappedStations = new ArrayList<>();
        RouteWrapperGet response = new RouteWrapperGet();

        //order may differ considerIt
        for(RouteEntity r : routeEntitiesDep){
            routeIds.add(r.getRouteId());
        }

        for (Integer id : routeIds ){
            List<RouteEntity> routeEntitiesArr = routeRepository.findRouteEntitiesByRouteIdOrderByOrdering(id);
            StationWrapperGet departure =null;
            for (RouteEntity r : routeEntitiesArr){

                if(r.getStationId() == search.getArrivalStationId()){
                    departure = new StationWrapperGet(r.getStationId(), stationRepository.findByStationId(r.getStationId()).getName(), r.getArrDate().toString(), r.getDepDate().toString());
                }

                if(r.getStationId() == search.getDestinationStationId()){
                    StationWrapperGet arrival = new StationWrapperGet(r.getStationId(), stationRepository.findByStationId(r.getStationId()).getName(), r.getArrDate().toString(), r.getDepDate().toString());
                    //here i get route with departure and arrival searched
                    wrappedStations.add(departure);
                    wrappedStations.add(arrival);
                    response.setStationWrapperGets(wrappedStations);
                    response.setRouteId(r.getRouteId());
                    response.setTrainId(r.getTrainId());
                }
            }
        }
        return response;
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRouteInstance(@RequestBody RouteWrapper routeStations){
        //getting the date of the first dep time and setting it to route instance

        List<StationWrapper> stationWrappers = routeStations.getStations();
        int id = 0;
        for (int i = 0; i < stationWrappers.size(); i++){
            Timestamp depTime = null;
            Timestamp arrTime = null;
            try{
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date paredDate = dateFormat.parse(stationWrappers.get(i).getDepTime());
                Date paredDate1 = dateFormat.parse(stationWrappers.get(i).getArrTime());
                depTime = new java.sql.Timestamp(paredDate.getTime());
                arrTime = new java.sql.Timestamp(paredDate1.getTime());
            }catch (Exception e){}


            if(i == 0) {
                routeRepository.save(new RouteEntity(stationWrappers.get(i).getId(), 1, arrTime, depTime, i, 0, " ", depTime));
                id = routeRepository.findTopByOrderByRouteIdDesc().getRouteId();
            }
            System.out.println(id);
            routeRepository.save(new RouteEntity(id,stationWrappers.get(i).getId(), 1, arrTime, depTime, i, 0, " ", depTime));

        }




    }

}
