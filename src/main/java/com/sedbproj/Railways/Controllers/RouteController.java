package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.RouteEntity;
import com.sedbproj.Railways.Repositories.RouteRepository;
import com.sedbproj.Railways.Repositories.StationRepository;
import com.sedbproj.Railways.Services.RouteService;
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

    @Autowired
    private RouteService routeService;

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/search",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RouteWrapperGet> getRoutesWithStations(@RequestBody SearchGet search){
        Timestamp dateStart = Timestamp.valueOf(search.getDate() + " 00:00:00");
        Timestamp dateEnd = Timestamp.valueOf(search.getDate() + " 23:59:59");
        List <RouteEntity> routeEntities = routeRepository.findRouteEntitiesByStationsAndDepDate(search.getArrivalStationId(),search.getDestinationStationId(), dateStart, dateEnd);

        Integer currRouteIdTemp = null;
        List<RouteWrapperGet> wrappedRoutes = new ArrayList<>();
        RouteWrapperGet wrappedRoute = new RouteWrapperGet();
        List <StationWrapperGet> wrappedStations = new ArrayList<>();
        for (int i = 0; i < routeEntities.size(); i++){
            StationWrapperGet currentStation = new StationWrapperGet(routeEntities.get(i).getStationId(),
                                                                  stationRepository.findByStationId(routeEntities.get(i).getStationId()).getName(),
                                                                  routeEntities.get(i).getArrDate().toString(),
                                                                  routeEntities.get(i).toString());
            if (currRouteIdTemp != null && currRouteIdTemp == routeEntities.get(i).getRouteId()){

                wrappedStations.add(currentStation);
                if(i == routeEntities.size() - 1) {
                    wrappedRoute.setStationWrapperGets(wrappedStations);
                    wrappedRoutes.add(wrappedRoute);
                    return wrappedRoutes;
                }
            }else {
                if(currRouteIdTemp == null){
                    wrappedRoute.setRouteId(routeEntities.get(i).getRouteId());
                    wrappedRoute.setTrainId(routeEntities.get(i).getTrainId());
                    wrappedStations.add(currentStation);
                }else {
                    wrappedRoute.setStationWrapperGets(wrappedStations); //setting stations of wraooedroute
                    wrappedRoutes.add(wrappedRoute); // adding it into response
                    wrappedRoute = new RouteWrapperGet(); // renew wrapper Route
                    wrappedRoute.setRouteId(routeEntities.get(i).getRouteId());
                    wrappedRoute.setTrainId(routeEntities.get(i).getTrainId());

                    wrappedStations = new ArrayList<>(); // renew stations
                    wrappedStations.add(currentStation); // adding station
                }
            }
            currRouteIdTemp = routeEntities.get(i).getRouteId();
        }

        return null;
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewRouteInstance(@RequestBody RouteWrapper routeStations){
        List<StationWrapper> stationWrappers = routeStations.getStations();
        Integer id = null;
        for (int i = 0; i < stationWrappers.size(); i++){
            Timestamp depTime =  Timestamp.valueOf(stationWrappers.get(i).getDepTime());
            Timestamp arrTime = Timestamp.valueOf(stationWrappers.get(i).getArrTime());
            if(i == 0) {
                routeService.createNewInstanceRoute(new RouteEntity(stationWrappers.get(i).getId(), routeStations.getTrain(), arrTime, depTime, i + 1));
                id = routeRepository.findTopByOrderByRouteIdDesc().getRouteId();
            }
            routeService.createNewInstanceRoute(new RouteEntity(id, stationWrappers.get(i).getId(), routeStations.getTrain(), arrTime, depTime, i + 1));
        }

    }

}
