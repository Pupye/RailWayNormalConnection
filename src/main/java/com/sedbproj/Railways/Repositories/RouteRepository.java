package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.RouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;


public interface RouteRepository extends CrudRepository<RouteEntity, Long> {
    RouteEntity findTopByOrderByRouteIdDesc();
    List<RouteEntity> findRouteEntitiesByDepDateBetweenAndStationId(Timestamp start, Timestamp end, Integer id);
    List<RouteEntity> findRouteEntitiesByRouteIdOrderByOrdering(Integer id);

}