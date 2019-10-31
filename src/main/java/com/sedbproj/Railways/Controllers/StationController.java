package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.StationEntity;
import com.sedbproj.Railways.Services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<StationEntity> getStationById(@PathVariable("id") Long id){
        return stationService.getStationById(id);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrSaveStation(@RequestBody StationEntity Station){
        stationService.createStation(Station);
    }

}
