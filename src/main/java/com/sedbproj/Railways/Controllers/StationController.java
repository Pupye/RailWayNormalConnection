package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Services.StationService;
import com.sedbproj.Railways.StationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StationEntity> getAllStations(){
        return stationService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrSaveStation(@RequestBody StationEntity Station){
        stationService.createStation(Station);
    }
}
