package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
    boolean existsBookEntityByRouteIdAndArriveStationIdAndDepartStationId1AndCarriageIdAndSeatNumAndSsn(
            Integer RouteId,
            Integer Arrive_StationId,
            Integer Depart_StationId1,
            Integer CarriageId,
            Integer SeatNumId,
            Long SSN
    );
}
