package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Repositories.RouteRepository;
import com.sedbproj.Railways.Entities.RouteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    public Iterable<RouteEntity> findAll(){
        return routeRepository.findAll();
    }

    public void createRoute (RouteEntity route){
        routeRepository.save(route);
    }

}
