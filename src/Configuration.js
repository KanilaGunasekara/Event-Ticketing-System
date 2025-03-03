import React, { useState } from 'react';
import axios from 'axios';
import './Configuration.css';

const Configuration = () => {
  const [totalTickets, setTotalTickets] = useState('');
  const [releaseRate, setReleaseRate] = useState('');
  const [retrievalRate, setRetrievalRate] = useState('');
  const [maxTickets, setMaxTickets] = useState('');
  const [vendorID, setVendorID] = useState('');

  // API URLs (Make sure these are correct based on your Spring Boot application)
  const API_URL = 'http://localhost:8080'; // Change to your actual backend URL

  const handleStart = async () => {
    try {
      const response = await axios.get(`${API_URL}/start`, {
        params: {
          vendorCount: vendorID, // For now, use vendorID for vendor count
          customerCount: 10, // Example value, change as necessary
          totalTickets: totalTickets,
          maxTicketCapacity: maxTickets,
          retrievalRate: retrievalRate,
          releaseRate: releaseRate,
        },
      });
      console.log('Start response:', response.data);
      alert(response.data); // Show response message in the browser
    } catch (error) {
      console.error('Error starting threads:', error);
      alert('Error starting threads: ' + error.message);
    }
  };

  const handleStop = async () => {
    try {
      const response = await axios.get(`${API_URL}/stop`);
      console.log('Stop response:', response.data);
      alert(response.data); // Show response message in the browser
    } catch (error) {
      console.error('Error stopping threads:', error);
      alert('Error stopping threads: ' + error.message);
    }
  };

  return (
    <div className="container">
      <h1 className="title">Configuration Page</h1>

      <div className="form-container">
        <h2 className="subtitle">Set Configuration Parameters</h2>

        <div className="grid">
          <div className="card">
            <label>Total Tickets</label>
            <input
              type="number"
              value={totalTickets}
              onChange={(e) => setTotalTickets(e.target.value)}
            />
          </div>

          <div className="card">
            <label>Ticket Release Rate</label>
            <input
              type="number"
              value={releaseRate}
              onChange={(e) => setReleaseRate(e.target.value)}
            />
          </div>

          <div className="card">
            <label>Customer Retrieval Rate (per second)</label>
            <input
              type="number"
              value={retrievalRate}
              onChange={(e) => setRetrievalRate(e.target.value)}
            />
          </div>

          <div className="card">
            <label>Max Ticket Capacity</label>
            <input
              type="number"
              value={maxTickets}
              onChange={(e) => setMaxTickets(e.target.value)}
            />
          </div>

          <div className="card">
            <label>Vendor ID</label>
            <input
              type="text"
              value={vendorID}
              onChange={(e) => setVendorID(e.target.value)}
            />
          </div>
        </div>

        <div className="button-container">
          <button className="start-button" onClick={handleStart}>
            Start
          </button>
          <button className="stop-button" onClick={handleStop}>
            Stop
          </button>
        </div>
      </div>
    </div>
  );
};

export default Configuration;
