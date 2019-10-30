package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Repositories.TicketRepository;
import com.sedbproj.Railways.Entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;

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
