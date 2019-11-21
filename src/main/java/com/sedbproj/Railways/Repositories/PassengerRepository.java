package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.PassengerEntity;
import com.sedbproj.Railways.Wrappers.bookWrappers.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<PassengerEntity, Long> {
    PassengerEntity findPassengerEntityBySsn(Long ssn);

}
