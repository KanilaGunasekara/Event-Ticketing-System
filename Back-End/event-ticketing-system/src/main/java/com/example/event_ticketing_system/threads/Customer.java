package com.example.event_ticketing_system.threads;

import com.example.event_ticketing_system.model.Ticket;
import com.example.event_ticketing_system.model.TicketPool;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int retrievalRate;
    public Customer(TicketPool ticketPool, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.retrievalRate = retrievalRate;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Ticket ticket = ticketPool.removeTicket(); // Retrieve a ticket
                if (ticket != null) {

                    System.out.println(Thread.currentThread().getName() + "purchased ticket: " + ticket);
                } else {
                    System.out.println(Thread.currentThread().getName() + "found no tickets available.");
                }
                Thread.sleep(retrievalRate); // Simulate delay between purchases
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
