public class Customer implements Runnable {
    private int quantity;
    private int customerRetrieveRate;
    private TicketPool ticketPool;

    // Constructor
    public Customer(int quantity, int customerRetrieveRate, TicketPool ticketPool) {
        this.quantity = quantity;
        this.customerRetrieveRate = customerRetrieveRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = ticketPool.removeTicket();
            if (ticket != null) {
                System.out.println("Successfully retrieved a ticket: " + ticket
                        + "\nCustomer: " + Thread.currentThread().getName());
            } else {
                System.out.println("No ticket available in the pool at the moment. Customer: "
                        + Thread.currentThread().getName());
            }

            try {
                Thread.sleep(customerRetrieveRate * 1000); // Delay the ticket retrieval process
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()
                        + " was interrupted. Ticket purchasing process has been stopped.");
                Thread.currentThread().interrupt(); // Restore the interrupt status
                break; // Exit the loop
            }
        }

        System.out.println("Customer: " + Thread.currentThread().getName()
                + " has finished retrieving tickets.");
    }
}


