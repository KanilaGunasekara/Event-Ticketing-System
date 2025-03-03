import React from 'react';

const Contact = () => {
  return (
    <div style={{
      maxWidth: '800px',
      margin: '40px auto',
      padding: '20px',
      backgroundColor: '#ffe4b3',
      borderRadius: '10px',
      boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)'
    }}>
      <h1 style={{ textAlign: 'center', marginBottom: '20px' }}>Contact Us</h1>
      <p style={{ textAlign: 'center', color: '#555' }}>
        Have a question or need assistance? We're here to help!
      </p>

      {/* Contact Information Section */}
      <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: '30px' }}>
        <div style={{ textAlign: 'center', flex: '1', margin: '0 10px' }}>
          <div style={{ fontSize: '40px', color: '#007BFF' }}>📧</div>
          <p>support@bookflow.com</p>
        </div>

        <div style={{ textAlign: 'center', flex: '1', margin: '0 10px' }}>
          <div style={{ fontSize: '40px', color: '#007BFF' }}>📞</div>
          <p>+94 (777) 777-7777</p>
        </div>

        <div style={{ textAlign: 'center', flex: '1', margin: '0 10px' }}>
          <div style={{ fontSize: '40px', color: '#007BFF' }}>📍</div>
          <p>300 Hill Street Avenue, Colombo 05, Sri Lanka</p>
        </div>
      </div>

      {/* Contact Form Section */}
      <div style={{ marginTop: '40px', padding: '20px', backgroundColor: '#fff', borderRadius: '10px', boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)' }}>
        <h2>Send Us a Message...</h2>
        <p style={{ color: '#777', marginBottom: '20px' }}>
          Fill out the form below, and we’ll get back to you as soon as possible.
        </p>
        <form>
          <div style={{ marginBottom: '15px' }}>
            <label style={{ display: 'block', marginBottom: '5px' }}>Your Name</label>
            <input
              type="text"
              style={{ width: '100%', padding: '10px', borderRadius: '5px', border: '1px solid #ccc' }}
              required
            />
          </div>

          <div style={{ marginBottom: '15px' }}>
            <label style={{ display: 'block', marginBottom: '5px' }}>Your Email</label>
            <input
              type="email"
              style={{ width: '100%', padding: '10px', borderRadius: '5px', border: '1px solid #ccc' }}
              required
            />
          </div>

          <div style={{ marginBottom: '20px' }}>
            <label style={{ display: 'block', marginBottom: '5px' }}>Your Message</label>
            <textarea
              style={{
                width: '100%',
                padding: '10px',
                borderRadius: '5px',
                border: '1px solid #ccc',
                minHeight: '100px'
              }}
              required
            ></textarea>
          </div>

          <button
            type="submit"
            style={{
              width: '100%',
              padding: '10px',
              backgroundColor: '#007BFF',
              color: 'white',
              border: 'none',
              borderRadius: '5px',
              fontSize: '16px',
              cursor: 'pointer'
            }}
          >
            Send Message
          </button>
        </form>
      </div>
    </div>
  );
};

export default Contact;
