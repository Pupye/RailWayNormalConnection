package com.sedbproj.Railways.Controllers;

import com.sedbproj.Railways.Repositories.TicketRepository;
import com.sedbproj.Railways.Entities.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketRepository ticketRepository;
    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<TicketEntity> getAllTickets(){
        return ticketRepository.findAll();
    }
    @CrossOrigin(origins="*")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTicket(@RequestBody TicketEntity ticketEntity){
        ticketRepository.save(ticketEntity);
    }
}
