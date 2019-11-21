package com.sedbproj.Railways.Controllers;


import com.sedbproj.Railways.Entities.StationEntity;
import com.sedbproj.Railways.Entities.UserEntity;
import com.sedbproj.Railways.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
