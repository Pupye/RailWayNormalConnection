package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.RouteEntity;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<RouteEntity, Long> {
    public RouteEntity findTopByOrderByIdRouteDesc();
}
