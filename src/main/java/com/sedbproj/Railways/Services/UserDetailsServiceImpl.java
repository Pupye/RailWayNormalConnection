package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Configuration.MyPasswordEncoder;
import com.sedbproj.Railways.Entities.UserDetailsImpl;
import com.sedbproj.Railways.Entities.UserEntity;
import com.sedbproj.Railways.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;

    private MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = usersRepository.findByEmail(email);
        UserDetailsImpl result = Optional.ofNullable(optionalUser).orElseThrow(()->new UsernameNotFoundException("Username Not Found"))
                .map(UserDetailsImpl::new).get();

        return result;
    }

    public UserEntity save(UserEntity user) {
        UserEntity newUser = new UserEntity();
        newUser.setEmail(user.getEmail());
        newUser.setFname(user.getFname() != null ? user.getFname() : "");
        newUser.setLname(user.getLname() != null ? user.getLname() : "");
//        newUser.setSsn(user.getSsn() != null ? user.getSsn() : null);
        newUser.setPassword(myPasswordEncoder.encode(user.getPassword()));

        System.out.println("----NEW USER----");
        System.out.println("Email:" + user.getEmail());
        System.out.println("First name:" + user.getFname());
        System.out.println("Last name:" + user.getLname());
        System.out.println("Employee entity:" + user.getEmployee());
        System.out.println("----------------");

        return usersRepository.save(newUser);
    }
}