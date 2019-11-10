package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.StationEntity;
import com.sedbproj.Railways.Services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StationEntity> getAllStations(){
        return stationService.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER')")
    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<StationEntity> getStationById(@PathVariable("id") Integer id){
        return stationService.getStationById(id);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrSaveStation(@RequestBody StationEntity Station){
        stationService.updateOrSaveStation(Station);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStationById(@PathVariable("id") Integer id){
        stationService.deleteStationById(id);
    }
}
