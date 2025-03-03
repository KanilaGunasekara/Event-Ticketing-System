package com.example.event_ticketing_system.service;

import com.example.event_ticketing_system.model.Ticket;
import com.example.event_ticketing_system.model.TicketPool;
import com.example.event_ticketing_system.repository.TicketRepository;
import com.example.event_ticketing_system.threads.Vendor;
import com.example.event_ticketing_system.threads.Customer;  // Add import for Customer

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    private final TicketPool ticketPool;
    private final TicketRepository ticketRepository;
    private final List<Thread> vendorThreads = new ArrayList<>();
    private final List<Thread> customerThreads = new ArrayList<>();
    private boolean threadsStopped = false;
    private final List<String> logMessages = new ArrayList<>();

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketPool = new TicketPool(ticketRepository);
    }

    // Starting the threads and adding tickets to the pool
    public void startThreads(int vendorCount, int customerCount, int totalTickets, int maxTicketCapacity, int retrievalRate, int releaseRate) {
        if (threadsStopped) {
            logMessage("Threads have already been stopped. Restarting now...");
            threadsStopped = false;
        }

        // Ensure tickets are added to the pool
        for (int i = 0; i < totalTickets && ticketPool.getTicketCount() < maxTicketCapacity; i++) {
            Ticket ticket = new Ticket();
            ticket.setEventName("BookFlow");
            ticket.setPrice(new BigDecimal("1000")); // Example price
            ticketPool.addTicket(ticket);
            logMessage("Ticket Added: " + ticket.getEventName());
        }

        // Create vendor threads
        for (int i = 0; i < vendorCount; i++) {
            Thread vendorThread = new Thread(new Vendor(ticketPool, totalTickets, releaseRate), "Vendor Thread " + (i + 1));
            vendorThreads.add(vendorThread);
            vendorThread.start();
            logMessage("Vendor thread initialized: Vendor Thread " + (i + 1));
        }

        // Create customer threads
        for (int i = 0; i < customerCount; i++) {
            Thread customerThread = new Thread(new Customer(ticketPool, retrievalRate), "Customer Thread " + (i + 1));
            customerThreads.add(customerThread);
            customerThread.start();
            logMessage("Customer thread initialized: Customer Thread " + (i + 1));
        }

        logMessage("Threads successfully launched with setup: Vendor Count: " + vendorCount + " | Customer Count: " + customerCount);
    }

    // Stop the threads
    public synchronized void stopThreads() {
        if (threadsStopped) {
            logMessage("The threads have already been halted.");
            return;
        }

        threadsStopped = true;

        for (Thread thread : vendorThreads) {
            if (thread.isAlive()) {
                thread.interrupt();
                logMessage("Vendor thread terminated: " + thread.getName());
            }
        }
        for (Thread thread : customerThreads) {
            if (thread.isAlive()) {
                thread.interrupt();
                logMessage("Customer thread terminated: " + thread.getName());
            }
        }

        vendorThreads.clear();
        customerThreads.clear();
        logMessage("All threads have been successfully terminated.");
    }

    public long getAvailableTickets() {
        long count = ticketRepository.countByAvailableTrue();
        System.out.println("Available tickets count: " + count);
        return count;
    }

    // Method to capture log messages
    private void logMessage(String message) {
        logMessages.add(message);
        logger.info(message);
    }

    // Optional method for getting logs for polling
    public List<String> getLogs() {
        return new ArrayList<>(logMessages);
    }
}