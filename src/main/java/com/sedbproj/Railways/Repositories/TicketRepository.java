package com.sedbproj.Railways.Repositories;

import com.sedbproj.Railways.Entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
}
