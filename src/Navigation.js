// Navigation.js
import React from 'react';
import './App.css';
import { Link } from 'react-router-dom';

const Navigation = () => {
  return (
    <nav className="navigation">
      <ul>
        <li><Link to="/Home">HOME</Link> </li>
        <li><Link to="/TicketStatus">STATUS</Link></li>
        <li><Link to="/Contact">CONTACT</Link></li>
        <li><Link to="/Configuration">SETTINGS</Link></li>
      </ul>
    </nav>
  );
}

export default Navigation;
