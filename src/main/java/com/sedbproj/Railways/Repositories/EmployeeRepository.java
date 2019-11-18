package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
}
