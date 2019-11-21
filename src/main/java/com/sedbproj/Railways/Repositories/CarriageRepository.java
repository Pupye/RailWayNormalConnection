package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.CarriageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarriageRepository extends CrudRepository<CarriageEntity, Integer> {
    List<CarriageEntity> getCarriageEntitiesByTrainId(Integer id);

    @Query(
            nativeQuery = true,
            value = "select Type from Carriage " +
                    "where CarriageId = :carriageId " +
                    "and TrainId = :trainId"
    )
    String getTypeByCarriageIdAndTrainId(@Param("carriageId") Integer carriageId, @Param("trainId") Integer trainId);
}
