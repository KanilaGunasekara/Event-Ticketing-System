package com.example.event_ticketing_system.model;

import com.example.event_ticketing_system.repository.TicketRepository; // Add this import statement
import java.util.Queue;
import java.util.LinkedList;

public class TicketPool {
    private final Queue<Ticket> tickets = new LinkedList<>();
    private final TicketRepository ticketRepository; // Assuming you are using a repository to persist tickets

    public TicketPool(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Adds a ticket to the pool
    public synchronized void addTicket(Ticket ticket) {
        tickets.offer(ticket);
        // Optionally save the ticket to the database
        ticketRepository.save(ticket);
    }

    // Retrieves a ticket from the pool
    public synchronized Ticket removeTicket() {
        return tickets.poll(); // Returns null if the queue is empty
    }

    // Gets the count of available tickets
    public long getTicketCount() {
        return tickets.size();
    }
}

