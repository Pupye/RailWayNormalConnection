package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.UserEntity;
import com.sedbproj.Railways.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
