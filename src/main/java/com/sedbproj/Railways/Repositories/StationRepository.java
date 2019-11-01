package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.StationEntity;
import org.springframework.data.repository.CrudRepository;


public interface StationRepository extends CrudRepository<StationEntity, Long> {

    StationEntity findByStationId(Integer Id);
}
