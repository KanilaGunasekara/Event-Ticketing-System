package com.example.event_ticketing_system.threads;

import com.example.event_ticketing_system.model.Ticket;
import com.example.event_ticketing_system.model.TicketPool; // Ensure this import is here
import java.math.BigDecimal;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int totalTickets;
    private final int releaseRate;

    public Vendor(TicketPool ticketPool, int totalTickets, int releaseRate) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < totalTickets; i++) {
                // Create a new ticket with necessary details
                Ticket ticket = new Ticket();
                ticket.setEventName("BookFlow");
                ticket.setPrice(new BigDecimal("1000")); // Example price logic
                ticket.setAvailable(true);

                // Add the ticket to the pool
                ticketPool.addTicket(ticket);

                // Simulate the release rate (delay between releasing tickets)
                Thread.sleep(releaseRate);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption
        }
    }
}



