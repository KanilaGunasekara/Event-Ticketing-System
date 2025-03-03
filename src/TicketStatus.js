import React, { Component } from 'react';
import './TicketStatus.css';

class TicketStatus extends Component {
  constructor(props) {
    super(props);
    this.state = {
      totalTickets: props.totalTickets || 0,
      ticketsReleased: props.ticketsReleased || 0,
    };
  }

  // Function to calculate remaining tickets
  calculateRemainingTickets = () => {
    const { totalTickets, ticketsReleased } = this.state;
    return totalTickets - ticketsReleased;
  };

  render() {
    const remainingTickets = this.calculateRemainingTickets();

    return (
      <div className="ticket-status-container">
        <h2 className="ticket-status-title">Remaining Tickets</h2>

        <div className="ticket-status-grid">
          <div className="status-card remaining">
            <h3>Remaining Tickets</h3>
            <p>{remainingTickets}</p>
            <div className="message">
              {remainingTickets > 0
                ? "Hurry Up! Tickets are still available."
                : "Sorry, No tickets left."}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default TicketStatus;
