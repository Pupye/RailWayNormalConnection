package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.PassengerEntity;
import com.sedbproj.Railways.Repositories.PassengerRepository;
import com.sedbproj.Railways.Wrappers.bookWrappers.PassengerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public void createIfNotExists(PassengerInfo passengerInfo, Integer passengerSsn){


            PassengerEntity newPassenger = new PassengerEntity(
                    passengerSsn,
                    passengerInfo.getFname(),
                    passengerInfo.getLname(),
                    passengerInfo.getPhoneNum(),
                    passengerInfo.getEmail()
            );

            passengerRepository.save(newPassenger);

    }

}
