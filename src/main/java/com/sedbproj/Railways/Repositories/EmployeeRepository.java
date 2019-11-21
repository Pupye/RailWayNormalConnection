package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
//    List<EmployeeEntity> getEmployeeEntitiesBy
}
