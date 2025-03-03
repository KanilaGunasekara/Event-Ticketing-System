public class Configuration {
    private int noOfVendors;
    private int noOfCustomers;
    private int totalTickets;
    private int ticketReleaseRate;
    private int quantity;
    private int maximumTicketCapacity;
    private int customerRetrievalRate;

    public Configuration(int noOfVendors, int noOfCustomers, int totalTickets, int ticketReleaseRate, int quantity, int maximumTicketCapacity, int customerRetrievalRate) {
        this.noOfVendors = noOfVendors;
        this.noOfCustomers = noOfCustomers;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.quantity = quantity;
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    // Getters and Setters with logs for changes
    public int getNoOfVendors() {
        return noOfVendors;
    }

    public void setNoOfVendors(int noOfVendors) {
        System.out.println("Number of Vendors updated from " + this.noOfVendors + " to " + noOfVendors);
        this.noOfVendors = noOfVendors;
    }

    public int getNoOfCustomers() {
        return noOfCustomers;
    }

    public void setNoOfCustomers(int noOfCustomers) {
        System.out.println("Number of Customers updated from " + this.noOfCustomers + " to " + noOfCustomers);
        this.noOfCustomers = noOfCustomers;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        System.out.println("Total Tickets updated from " + this.totalTickets + " to " + totalTickets);
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        System.out.println("Ticket Release Rate updated from " + this.ticketReleaseRate + " to " + ticketReleaseRate);
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        System.out.println("Quantity updated from " + this.quantity + " to " + quantity);
        this.quantity = quantity;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setMaximumTicketCapacity(int maximumTicketCapacity) {
        System.out.println("Maximum Ticket Capacity updated from " + this.maximumTicketCapacity + " to " + maximumTicketCapacity);
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        System.out.println("Customer Retrieval Rate updated from " + this.customerRetrievalRate + " to " + customerRetrievalRate);
        this.customerRetrievalRate = customerRetrievalRate;
    }
}
