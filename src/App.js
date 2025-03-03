import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Navigation from './Navigation.js';
import Home from './Home';
import TicketStatus from './TicketStatus.js';
import Contact from './Contact.js';
import Configuration from './Configuration';

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header" style={{
          backgroundColor: '#333',
          color: 'white',
          padding: '20px 0',
          textAlign: 'center',
        }}>
          <h1 style={{ margin: 0, fontSize: '2.5rem', letterSpacing: '2px' }}>BookFlow</h1>
        </header>

        {/* Navigation Bar */}
        <Navigation />

        {/* Routes */}
        <div style={{ padding: '20px' }}>
          <Routes>
            <Route path="/Home" element={<Home />} />
            <Route path="/TicketStatus" element={<TicketStatus />} />
            <Route path="/Contact" element={<Contact />} />
            <Route path="/Configuration" element={<Configuration />} />
          </Routes>
        </div>

        {/* Footer Section */}
        <footer style={{
          backgroundColor: '#222',
          color: 'white',
          textAlign: 'center',
          padding: '10px 0',
          marginTop: '20px',
        }}>
          <p style={{ margin: '5px 0' }}>&copy; 2024 BookFlow. All rights reserved.</p>
          <p style={{ margin: '5px 0' }}>
            Contact us at{' '}
            <a
              href="mailto:support@bookflow.com"
              style={{ color: '#f37c0c', textDecoration: 'none' }}
            >
              support@bookflow.com
            </a>
          </p>
        </footer>
      </div>
    </Router>
  );
}

export default App;

