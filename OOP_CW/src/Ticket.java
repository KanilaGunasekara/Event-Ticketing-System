import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String ticketName;
    private BigDecimal ticketPrice;

    // Constructor
    public Ticket(int ticketId, String ticketName, BigDecimal ticketPrice) {
        if (ticketId < 0) {
            throw new IllegalArgumentException("Ticket ID cannot be negative. Provided: " + ticketId);
        }
        if (ticketName == null || ticketName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket name cannot be null or empty.");
        }
        if (ticketPrice == null || ticketPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Ticket price must be a non-negative value. Provided: " + ticketPrice);
        }

        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketId(int ticketId) {
        if (ticketId < 0) {
            throw new IllegalArgumentException("Ticket ID cannot be negative. Provided: " + ticketId);
        }
        this.ticketId = ticketId;
    }

    public void setTicketName(String ticketName) {
        if (ticketName == null || ticketName.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket name cannot be null or empty.");
        }
        this.ticketName = ticketName;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        if (ticketPrice == null || ticketPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Ticket price must be a non-negative value. Provided: " + ticketPrice);
        }
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return String.format("Ticket [ID: %d, Name: %s, Price: %s]",
                ticketId, ticketName, ticketPrice.toPlainString());
    }
}
