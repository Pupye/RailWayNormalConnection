package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Repositories.RouteHasStationRepository;
import com.sedbproj.Railways.Entities.RouteHasStationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/in-route-stations")
public class InRouteStationController {
    @Autowired
    private RouteHasStationRepository routeHasStationRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<RouteHasStationEntity> getAll(){
        return routeHasStationRepository.findAll();
    }
    @CrossOrigin(origins="*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Iterable<RouteHasStationEntity> getRoutesById(@PathVariable("id") Integer id){
        return routeHasStationRepository.getRouteHasStationEntitiesByRouteIdRoute(id);
    }
}
