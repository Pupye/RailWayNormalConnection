package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.RouteHasStationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteHasStationRepository extends CrudRepository<RouteHasStationEntity, Long> {
    //we can add custom methods for data access
}

