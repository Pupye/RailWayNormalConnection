package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Repositories.RouteRepository;
import com.sedbproj.Railways.Repositories.StationRepository;
import com.sedbproj.Railways.RouteEntity;
import com.sedbproj.Railways.StationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepository;

    public Iterable<StationEntity> findAll(){
        return stationRepository.findAll();
    }

    public void createStation (StationEntity station){
        stationRepository.save(station);
    }
}
