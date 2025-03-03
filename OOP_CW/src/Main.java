import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Prompt for user inputs for configuration parameters
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator(scanner);

        System.out.print("Enter the total number of vendors: ");
        int noOfVendors = validator.getValidInput("The number of vendors must be a positive integer. Please try again.");

        System.out.print("Enter the number of customers: ");
        int noOfCustomers = validator.getValidInput("The number of customers must be a positive integer. Please try again.");

        System.out.print("Enter the total number of tickets: ");
        int totalTickets = validator.getValidInput("The total number of tickets must be a positive integer. Please try again.");

        System.out.print("Enter the frequency of releasing tickets: ");
        int ticketReleaseRate = validator.getValidInput("The ticket release frequency must be a positive integer. Please try again.");

        System.out.print("Enter the quantity: ");
        int quantity = validator.getValidInput("The quantity must be a positive integer. Please try again.");

        System.out.print("Enter the maximum ticket capacity: ");
        int maximumTicketCapacity = validator.getValidInput("The maximum ticket capacity must be a positive integer. Please try again.");

        System.out.print("Enter the frequency of purchasing tickets: ");
        int customerRetrievalRate = validator.getValidInput("The ticket purchasing frequency must be a positive integer. Please try again.");

        Configuration config = new Configuration(noOfVendors, noOfCustomers, totalTickets, ticketReleaseRate, quantity, maximumTicketCapacity, customerRetrievalRate);
        saveConfigToJson(config, "Configuration.json");

        boolean running = true;
        while (running) {
            System.out.println("-".repeat(40));
            System.out.println("\tReal Time Event Ticketing System");
            System.out.println("-".repeat(40));
            System.out.println("1. Start");
            System.out.println("2. Stop");
            System.out.println("3. Exit");
            System.out.print("Enter command: ");

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    //Create an instance of ticketpool class with maximum capacity given
                    TicketPool ticketpool = new TicketPool(maximumTicketCapacity);
                    Vendor[] vendors = new Vendor[noOfVendors]; //creating an array of vendors

                    //Create vendor threads in order to number of vendors user assigned
                    for(int count=0; count<vendors.length; count++){
                        vendors[count]= new Vendor(totalTickets,ticketReleaseRate,ticketpool);
                        Thread vendorThread = new Thread(vendors[count], "Vendor: "+(count+1));
                        vendorThreads.add(vendorThread);
                        vendorThread.start();
                    }

                    //Create customer threads in order to number of customers user assigned
                    Customer[] customers = new Customer[noOfCustomers]; //creating an array of customers
                    for(int count=0; count<customers.length; count++){
                        customers[count]= new Customer(quantity,customerRetrievalRate,ticketpool);
                        Thread customerThread = new Thread(customers[count], "Customer: "+(count+1));
                        customerThreads.add(customerThread);
                        customerThread.start();
                    }
                    break;
                case 2:
                    stopAllThreads();
                    System.out.println("Stopped customer and vendor threads and stepping to the main menu!");
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }
    static List<Thread> vendorThreads = new ArrayList<>();
    static List<Thread> customerThreads = new ArrayList<>();
    private static void stopAllThreads() {
        for (Thread thread : vendorThreads) {
            thread.interrupt();
        }
        for (Thread thread : customerThreads) {
            thread.interrupt();
        }
    }

    public static void saveConfigToJson(Configuration config, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(config, writer);
            System.out.println("Configuration saved to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}

class Validator {
    private final Scanner scanner;

    // Constructor to initialize the scanner
    public Validator(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method to validate input
    public Boolean validateInput(int input) {
        return input >= 1;
    }

    // Method to prompt for valid input
    public int getValidInput(String errorMessage) {
        int input;
        while (true) {
            input = scanner.nextInt();
            if (validateInput(input)) {
                break; // Exit the loop if input is valid
            } else {
                System.out.println(errorMessage);// Show the error message
                System.out.print("Enter the input again: ");
            }
        }
        return input; // Return the valid input
    }
}