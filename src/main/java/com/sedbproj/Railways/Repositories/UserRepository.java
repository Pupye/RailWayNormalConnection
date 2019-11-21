package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByFnameAndLname(String fname, String lname);
    Boolean existsByFnameAndLname(String fname, String lname);
}
