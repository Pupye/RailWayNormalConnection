package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.CarriageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarriageRepository extends CrudRepository<CarriageEntity, Integer> {
    List<CarriageEntity> getCarriageEntitiesByTrainId(Integer id);
}
