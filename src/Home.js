import React from 'react';
import background from './assets/img/bg.jpeg'; // Replace with a suitable background image

const Home = () => {
  return (
    <div
      style={{
        position: 'relative',
        backgroundImage: `url(${background})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        backgroundRepeat: 'no-repeat',
        minHeight: '100vh',
        width: '100%',
        overflow: 'hidden',
      }}
    >
      {/* Overlay */}
      <div
        style={{
          position: 'absolute',
          top: 0,
          left: 0,
          right: 0,
          bottom: 0,
          backgroundColor: 'rgba(0, 0, 0, 0.5)',
          zIndex: 1,
        }}
      ></div>

      {/* Hero Section */}
      <div
        style={{
          position: 'relative',
          zIndex: 2,
          textAlign: 'center',
          color: 'white',
          fontFamily: "'Montserrat', sans-serif",
          padding: '60px 20px',
        }}
      >
        <h1
          style={{
            fontSize: '3.5rem',
            fontWeight: 'bold',
            textTransform: 'uppercase',
            letterSpacing: '3px',
            marginBottom: '20px',
            animation: 'fadeIn 1.5s ease-out',
          }}
        >
          Experience the Thrill of Halloween
        </h1>

        <p
          style={{
            fontSize: '1.2rem',
            marginBottom: '30px',
            fontWeight: 'lighter',
            textShadow: '2px 2px 5px rgba(0, 0, 0, 0.6)',
            animation: 'fadeIn 2s ease-out',
          }}
        >
          Dive into a world of haunting adventures and spectacular events designed just for you.
        </p>
      </div>

      {/* Three-Section Layout */}
      <div
        style={{
          display: 'grid',
          gridTemplateColumns: 'repeat(3, 1fr)',
          gap: '20px',
          padding: '40px',
          zIndex: 2,
          position: 'relative',
        }}
      >
        {/* Section 1 */}
        <div
          style={{
            backgroundColor: '#ffe4b3',
            color: '#333333',
            padding: '20px',
            borderRadius: '12px',
            boxShadow: '0 8px 16px rgba(0, 0, 0, 0.2)',
            textAlign: 'center',
          }}
        >
          <h3 style={{ marginBottom: '15px' }}>Event Highlights</h3>
          <p style={{ fontSize: '1rem', color: '#555' }}>
            Discover the most exciting events of the season.
          </p>
        </div>

        {/* Section 2 */}
        <div
          style={{
            backgroundColor: '#ffe4b3',
            color: '#333333',
            padding: '20px',
            borderRadius: '12px',
            boxShadow: '0 8px 16px rgba(0, 0, 0, 0.2)',
            textAlign: 'center',
          }}
        >
          <h3 style={{ marginBottom: '15px' }}>Special Guests</h3>
          <p style={{ fontSize: '1rem', color: '#555' }}>
            Meet the celebrities and performers making this event unforgettable.
          </p>
        </div>

        {/* Section 3 */}
        <div
          style={{
            backgroundColor: '#ffe4b3',
            color: '#333333',
            padding: '20px',
            borderRadius: '12px',
            boxShadow: '0 8px 16px rgba(0, 0, 0, 0.2)',
            textAlign: 'center',
          }}
        >
          <h3 style={{ marginBottom: '15px' }}>FAQs</h3>
          <p style={{ fontSize: '1rem', color: '#555' }}>
            Get answers to all your event-related questions.
          </p>
        </div>
      </div>
    </div>
  );
};

export default Home;

