package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Repositories.RouteHasStationRepository;
import com.sedbproj.Railways.Entities.RouteHasStationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteHasStationService {

    @Autowired
    private RouteHasStationRepository routeHasStationRepository;

    public Iterable<RouteHasStationEntity> getAllRouteHasStations(){
        return routeHasStationRepository.findAll();
    }

    public void saveRouteHasStation(RouteHasStationEntity routeInstance){
        routeHasStationRepository.save(routeInstance);
    }


}
