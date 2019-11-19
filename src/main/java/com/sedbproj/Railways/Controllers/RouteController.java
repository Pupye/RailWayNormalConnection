package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.CarriageEntity;
import com.sedbproj.Railways.Entities.RouteEntity;
import com.sedbproj.Railways.Errors.RouteNotFoundException;
import com.sedbproj.Railways.Repositories.CarriageRepository;
import com.sedbproj.Railways.Repositories.RouteRepository;
import com.sedbproj.Railways.Repositories.StationRepository;
import com.sedbproj.Railways.Services.RouteService;
import com.sedbproj.Railways.Wrappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private RouteService routeService;

    @Autowired
    private CarriageRepository carriageRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(value = "/search",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RouteWrapperGet> getRoutesWithStations(@RequestBody SearchGet search){
        Timestamp dateStart = Timestamp.valueOf(search.getDate() + " 00:00:00");
        Timestamp dateEnd = Timestamp.valueOf(search.getDate() + " 23:59:59");
        List <RouteEntity> routeEntities = routeRepository.findRouteEntitiesByStationsAndDepDate(search.getArrivalStationId(),search.getDestinationStationId(), dateStart, dateEnd);
        //sending 404 if routeEntities's size == 0
        if (routeEntities.size() == 0){
            throw new RouteNotFoundException();
        }
        System.out.println(search.getArrivalStationId() + "this is my print");
        Integer currRouteIdTemp = null;
        List<RouteWrapperGet> wrappedRoutes = new ArrayList<>();
        RouteWrapperGet wrappedRoute = new RouteWrapperGet();
        List <StationWrapperGet> wrappedStations = new ArrayList<>();

        //setting up carriages

        for (int i = 0; i < routeEntities.size(); i++){
            String arrivalDate = routeEntities.get(i).getArrDate()==null ? null : routeEntities.get(i).getArrDate().toString();
            String departureDate = routeEntities.get(i).getDepDate()==null ? null : routeEntities.get(i).getDepDate().toString();
            StationWrapperGet currentStation = new StationWrapperGet(
                    routeEntities.get(i).getStationId(),
                    stationRepository.findByStationId(routeEntities.get(i).getStationId()).getName(),
                    arrivalDate,
                    departureDate
            );


            if (currRouteIdTemp != null && currRouteIdTemp == routeEntities.get(i).getRouteId()){

                wrappedStations.add(currentStation);
                if(i == routeEntities.size() - 1) {
                    wrappedRoute.setStationWrapperGets(wrappedStations);
                    wrappedRoutes.add(wrappedRoute);
                    return wrappedRoutes;
                }
            }else {
                if(currRouteIdTemp == null){
                    setTheWrapperForNew(routeEntities, wrappedRoute, i);
                    //
                    wrappedStations.add(currentStation);
                }else {
                    wrappedRoute.setStationWrapperGets(wrappedStations); //setting stations of wraooedroute
                    wrappedRoutes.add(wrappedRoute); // adding it into response
                    wrappedRoute = new RouteWrapperGet(); // renew wrapper Route
                    setTheWrapperForNew(routeEntities, wrappedRoute, i);

                    wrappedStations = new ArrayList<>(); // renew stations
                    wrappedStations.add(currentStation); // adding station
                }
            }
            currRouteIdTemp = routeEntities.get(i).getRouteId();
        }

        return wrappedRoutes;
    }

    private void setTheWrapperForNew(List<RouteEntity> routeEntities, RouteWrapperGet wrappedRoute, int i) {
        wrappedRoute.setRouteId(routeEntities.get(i).getRouteId());
        wrappedRoute.setTrainId(routeEntities.get(i).getTrainId());
        List<CarriageEntity> carriageEntities = carriageRepository.getCarriageEntitiesByTrainId(routeEntities.get(i).getTrainId());
        List<CarriageWrapperGet> wrappedCarriages = new ArrayList<>();
        getWrappedCarriages(wrappedCarriages, carriageEntities);
        wrappedRoute.setCarriageWrappers(wrappedCarriages);
    }

    private void getWrappedCarriages(List<CarriageWrapperGet> wrappedCarriages, List<CarriageEntity> carriageEntities) {
        for (CarriageEntity carriage : carriageEntities){
            wrappedCarriages.add(new CarriageWrapperGet(carriage.getType(), carriage.getTotalSeats()));
        }
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
