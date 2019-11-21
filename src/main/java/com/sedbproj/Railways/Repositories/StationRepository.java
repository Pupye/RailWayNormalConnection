package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.StationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface StationRepository extends CrudRepository<StationEntity, Integer> {

    StationEntity findByStationId(Integer Id);

    @Query(
            nativeQuery = true,
            value = "select Name from Station " +
                    "where StationId = :stationId "
    )
    String getStationNameById(@Param("stationId") Integer stationId);
}
