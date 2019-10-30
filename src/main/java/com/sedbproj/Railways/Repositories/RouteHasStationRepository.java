package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.RouteHasStationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteHasStationRepository extends CrudRepository<RouteHasStationEntity, Long> {
    Iterable<RouteHasStationEntity> getRouteHasStationEntitiesByRouteIdRoute(Integer RouteIdRoute);
}

