package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.RouteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;


public interface RouteRepository extends CrudRepository<RouteEntity, Long> {
    RouteEntity findTopByOrderByRouteIdDesc();
    @Query(
            nativeQuery = true,
            value = "select R3.RouteId, R3.StationId, R3.TrainId, R3.ArrDate, R3.DepDate, R3.Ordering, R3.Cancelled, R3.CancelDesc, R3.CancelDate " +
                    "from Route R3, (select R1.RouteId as Id, R1.Ordering as startFrom, R2.Ordering as endOn " +
                    "from Route R1, Route R2 " +
                    "where R1.routeid = R2.routeId " +
                    "and R1.StationId = :departureId " +
                    "and R2.StationId = :destinationId " +
                    "and R2.ordering > R1.ordering " +
                    "and R1.depDate between :startDate and :endDate ) as T1\n" +
                    "where R3.RouteId = T1.Id " +
                    "and R3.Ordering between T1.startFrom and T1.endOn " +
                    "order by R3.RouteId, R3.Ordering "

    )
    List <RouteEntity> findRouteEntitiesByStationsAndDepDate(@Param("departureId") Integer departureId,
                                                            @Param("destinationId") Integer destinationId,
                                                            @Param("startDate") Timestamp startDate,
                                                            @Param("endDate") Timestamp endDate);
    @Query(
            nativeQuery = true,
            value = "select max(ArrDate) " +
                    "from Route " +
                    "where TrainId = :trainId "
    )
    Timestamp trainBusyDate(@Param("trainId") Integer trainId);
}