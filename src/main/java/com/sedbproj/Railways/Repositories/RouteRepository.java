package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.RouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RouteRepository extends CrudRepository<RouteEntity, Long> {
    RouteEntity findTopByOrderByRouteIdDesc();
}
