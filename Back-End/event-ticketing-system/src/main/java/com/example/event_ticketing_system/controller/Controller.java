package com.example.event_ticketing_system.controller;

import com.example.event_ticketing_system.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private final TicketService ticketService;
    @Autowired
    public Controller(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/start")
    public String startThreads(
            @RequestParam int vendorCount,
            @RequestParam int customerCount,
            @RequestParam int totalTickets,
            @RequestParam int maxTicketCapacity,
            @RequestParam int retrievalRate,
            @RequestParam int releaseRate) {
        try {
            ticketService.startThreads(vendorCount, customerCount, totalTickets, maxTicketCapacity,
                    retrievalRate, releaseRate);
            String logMessage = " Vendor and Customer threads successfully initialized with the specified configuration!";
            logger.info(logMessage); // Log message will be saved in logs
            return logMessage;
        } catch (Exception e) {
            String errorMessage = "Failed to initialize threads: " + e.getMessage();
            logger.error(errorMessage, e);
            return errorMessage;
        }

    }
    @GetMapping("/stop")
    public String stopThreads() {
        try {
            ticketService.stopThreads();
            String logMessage = "Vendor and Customer threads have been stopped!";
            logger.info(logMessage); // Log message will be saved in logs
            return logMessage;
        } catch (Exception e) {
            String errorMessage = "Failed to stop threads: " + e.getMessage();
            logger.error(errorMessage, e);
            return errorMessage;
        }
    }
    @GetMapping("/available")
    public long getAvailableTickets() { // Return type changed to long
        long count = ticketService.getAvailableTickets();
        logger.info("Available tickets count: " + count);
        return count;
    }
    @GetMapping("/logger")
    public List<String> getLogs() {
        return ticketService.getLogs(); // Return the latest logs
    }
}