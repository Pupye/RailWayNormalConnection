package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.RouteEntity;
import com.sedbproj.Railways.Repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    public void createNewInstanceRoute (RouteEntity route){
        //TODO you may consider whether train is available
        routeRepository.save(route);
    }
}
