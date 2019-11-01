package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.CarriageEntity;
import com.sedbproj.Railways.Repositories.CarriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carriages")
public class CarriageController {
    @Autowired
    private CarriageRepository carriageRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CarriageEntity> getAllStations(){
        return carriageRepository.findAll();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<CarriageEntity> getCarriagesByTrainId(@PathVariable("id") Integer id){
        return carriageRepository.getCarriageEntitiesByTrainId(id);
    }
}
