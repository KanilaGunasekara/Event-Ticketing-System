import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private int maxTicketCapacity;
    private Queue<Ticket> ticketQueue;

    public TicketPool(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.ticketQueue = new LinkedList<>();
    }

    // Vendors will call the addTicket() method
    public synchronized void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maxTicketCapacity) {
            try {
                System.out.println("Ticket pool is full. Vendor " + Thread.currentThread().getName() + " is waiting to add tickets...");
                wait();
            } catch (InterruptedException e) {
                System.err.println("Vendor thread " + Thread.currentThread().getName() + " was interrupted while waiting to add tickets.");
                Thread.currentThread().interrupt(); // Restore the interrupt status
                throw new RuntimeException("Vendor operation interrupted: " + e.getMessage());
            }
        }
        ticketQueue.add(ticket);
        notifyAll(); // Notify all the waiting threads
        System.out.println("Ticket successfully added to the pool by: " + Thread.currentThread().getName() +
                "\nCurrent pool size: " + ticketQueue.size());
    }

    // Customers will call the removeTicket() method
    public synchronized Ticket removeTicket() {
        while (ticketQueue.isEmpty()) {
            try {
                System.out.println("Ticket pool is empty. Customer " + Thread.currentThread().getName() + " is waiting for tickets...");
                wait();
            } catch (InterruptedException e) {
                System.err.println("Customer thread " + Thread.currentThread().getName() + " was interrupted while waiting for tickets.");
                Thread.currentThread().interrupt(); // Restore the interrupt status
                throw new RuntimeException("Customer operation interrupted: " + e.getMessage());
            }
        }
        Ticket ticket = ticketQueue.poll(); // Retrieve and remove the head of the queue
        notifyAll(); // Notify all waiting threads
        System.out.println("Ticket successfully removed from the pool by: " + Thread.currentThread().getName() +
                "\nCurrent pool size: " + ticketQueue.size());
        return ticket;
    }
}

