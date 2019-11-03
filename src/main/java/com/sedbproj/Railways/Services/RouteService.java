package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.RouteEntity;
import com.sedbproj.Railways.Repositories.RouteRepository;
import com.sedbproj.Railways.Repositories.StationRepository;
import com.sedbproj.Railways.Wrappers.RouteWrapperGet;
import com.sedbproj.Railways.Wrappers.SearchGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    StationRepository stationRepository;
    public List<RouteEntity> getRoutesBetweenStationsOnDate(Integer departureId,
                                                            Integer destinationId,
                                                            Timestamp depDate,
                                                            Timestamp arrDate){

        return null;
    }

    public Iterable<RouteEntity> findAll(){
        return routeRepository.findAll();
    }

    public void createRoute (RouteEntity route){
        routeRepository.save(route);
    }

}
