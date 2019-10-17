package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Repositories.RouteHasTrainRepository;
import com.sedbproj.Railways.RouteEntity;
import com.sedbproj.Railways.RouteHasTrainEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class RouteHasTrainService {
    @Autowired
    RouteHasTrainRepository routeHasTrainRepository;

    public Iterable<RouteHasTrainEntity> findAll(){
        return routeHasTrainRepository.findAll();
    }

    public void createRoute (RouteHasTrainEntity route){
        routeHasTrainRepository.save(route);
    }
}
