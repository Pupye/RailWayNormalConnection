package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Entities.PassengerEntity;
import com.sedbproj.Railways.Repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    PassengerRepository passengerRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<PassengerEntity> getAllPassengers(){
        return passengerRepository.findAll();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<PassengerEntity> getPassengerBySsn(@PathVariable("id") Long id){
        return passengerRepository.findById(id);
    }
}
