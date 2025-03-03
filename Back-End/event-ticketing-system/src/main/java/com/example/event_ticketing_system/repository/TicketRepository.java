package com.example.event_ticketing_system.repository;

import com.example.event_ticketing_system.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // You can add custom query methods here if needed
    long countByAvailableTrue();
}


