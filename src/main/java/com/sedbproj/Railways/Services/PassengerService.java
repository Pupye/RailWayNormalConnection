package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.PassengerEntity;
import com.sedbproj.Railways.Entities.UserEntity;
import com.sedbproj.Railways.Repositories.PassengerRepository;
import com.sedbproj.Railways.Repositories.UserRepository;
import com.sedbproj.Railways.Wrappers.bookWrappers.PassengerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private UserRepository userRepository;

    public void createIfNotExists(PassengerInfo passengerInfo, Long passengerSsn) {

        if (!passengerRepository.existsById(passengerSsn)) {
            PassengerEntity newPassenger = new PassengerEntity(
                    passengerSsn,
                    passengerInfo.getFname(),
                    passengerInfo.getLname(),
                    passengerInfo.getPhoneNum(),
                    passengerInfo.getEmail()
            );
            passengerRepository.save(newPassenger);

            Optional<UserEntity> user = userRepository.findByFnameAndLname(passengerInfo.getFname(), passengerInfo.getLname());
            if (user.isPresent()) {
                user.get().setFname(passengerInfo.getFname());
                user.get().setLname(passengerInfo.getLname());
            }
        }
    }

}
