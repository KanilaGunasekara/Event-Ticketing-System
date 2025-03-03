import java.math.BigDecimal;

public class Vendor implements Runnable {
    private int totalTickets; // Total tickets the vendor is willing to sell
    private int ticketReleaseRate; // Frequency of releasing tickets (in seconds)
    private TicketPool ticketPool; // Shared resource between vendors and customers

    // Constructor
    public Vendor(int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 0; i < totalTickets; i++) {
            Ticket ticket = new Ticket(i, "My Event: Ticket #" + (i + 1), new BigDecimal("2000"));
            try {
                ticketPool.addTicket(ticket); // Add the ticket to the pool
                System.out.println("Vendor " + Thread.currentThread().getName() +
                        " successfully added Ticket #" + (i + 1));
                Thread.sleep(ticketReleaseRate * 1000); // Delay the ticket release
            } catch (InterruptedException e) {
                // Handle thread interruption gracefully
                System.err.println("Vendor " + Thread.currentThread().getName() +
                        " was interrupted while releasing tickets. Stopping further ticket release.");
                Thread.currentThread().interrupt(); // Restore the interrupt status
                break; // Exit the loop to stop the thread
            } catch (Exception e) {
                // Handle any unexpected exceptions during ticket addition
                System.err.println("An error occurred while Vendor " + Thread.currentThread().getName() +
                        " was adding a ticket: " + e.getMessage());
                break; // Exit the loop if an unexpected error occurs
            }
        }

        System.out.println("Vendor " + Thread.currentThread().getName() +
                " has completed ticket release. Total tickets released: " + totalTickets);
    }
}


