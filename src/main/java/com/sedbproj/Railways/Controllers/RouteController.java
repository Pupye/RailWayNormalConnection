package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Repositories.RouteHasStationRepository;
import com.sedbproj.Railways.Repositories.RouteRepository;
import com.sedbproj.Railways.Entities.RouteEntity;
import com.sedbproj.Railways.Entities.RouteHasStationEntity;
import com.sedbproj.Railways.Wrappers.RouteWrapper;
import com.sedbproj.Railways.Wrappers.StationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    private RouteHasStationRepository routeHasStationRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<RouteEntity> getAll(){
        return routeRepository.findAll();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRouteInstance(@RequestBody RouteWrapper routeStations){
        //getting the date of the first dep time and setting it to route instance

        RouteEntity route1 = new RouteEntity(routeStations.getStations().get(0).getDepTime());
        routeRepository.save(route1);
        int routeId  = routeRepository.findTopByOrderByIdRouteDesc().getIdRoute();

        List<StationWrapper> stationWrappers = routeStations.getStations();
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
            routeHasStationRepository.save(new RouteHasStationEntity(routeId, stationWrappers.get(i).getId(), i, routeStations.getCapacity(), depTime, arrTime));

        }




    }

}
