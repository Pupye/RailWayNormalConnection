package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Repositories.StationRepository;
import com.sedbproj.Railways.Repositories.TicketRepository;
import com.sedbproj.Railways.StationEntity;
import com.sedbproj.Railways.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.krb5.internal.Ticket;

public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public Iterable<TicketEntity> findAll(){
        return ticketRepository.findAll();
    }

    public void createRoute (TicketEntity ticketEntity){
        ticketRepository.save(ticketEntity);
    }
}
