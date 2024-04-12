
const express = require('express');
const nodemailer = require('nodemailer');
const cors = require('cors');
const router = express.Router();

const app = express();
const PORT = process.env.PORT || 3000;
 
// Create a map to store OTPs associated with email addresses
const otpMap = new Map();
 
// Define a variable to store OTPs temporarily
let otpStorage = {};
 
app.use(express.json());
app.use(cors());
 
/*app.post('/checkEmail', async (req, res) => {
  const { email } = req.body;
 
  try {
    // Query the database to check if the email exists
    pool.query('SELECT * FROM users WHERE Email = ?', [email], (error, results) => {
      if (error) {
        console.error('Error checking email:', error);
        res.status(500).json({ error: 'Internal server error' });
      } else {
        if (results.length > 0) {
          // Email exists in the database
          res.status(200).json({ exists: true });
        } else {
          // Email does not exist in the database
          res.status(404).json({ exists: false });
        }
      }
    });
  } catch (error) {
    console.error('Error checking email:', error);
    res.status(500).json({ error: 'Internal server error' });
  }
});*/
 
module.exports = router;
// Define a route for sending emails
app.post('/sendEmail', (req, res) => {
  const { to, subject } = req.body;
 
  // Generate OTP
  const otp = generateOTP();
 
  // Store the generated OTP associated with the email
  storeOTP(to, otp);
 
  // Create a Nodemailer transporter
  const transporter = nodemailer.createTransport({
    service: 'Gmail',
    auth: {
      user: 'dxcinsuranceaggregator@gmail.com',
      pass: 'gzqrpwvudccxfrqz'
    }
  });
 
  // Define email options
  const mailOptions = {
    from: 'dxcinsuranceaggregator@gmail.com',
    to,
    subject,
    text: `Your OTP for resetting the password is: ${otp}`
  };
 
  // Send email
  transporter.sendMail(mailOptions, (error, info) => {
    if (error) {
      console.error('Error sending email:', error);
      res.status(500).json({ error: 'Failed to send email' });
    } else {
      console.log('Email sent:', info.response);
      res.status(200).json({ message: 'Email sent successfully', email: to });
    }
  });
});
 
// Endpoint to verify OTP
app.post('/verifyOTP', (req, res) => {
  const { otp } = req.body; // Only need OTP from the request body
 
  // Check if OTP is present
  if (!otp) {
    return res.status(400).json({ error: "OTP is required." });
  }
 
  // Retrieve the correct OTP associated with the email
  const storedOTP = Object.values(otpStorage).find(storedOtp => storedOtp === otp);
 
  // Check if the correct OTP exists
  if (!storedOTP) {
    return res.status(404).json({ error: "Invalid OTP." });
  }
 
  // OTP is valid
  return res.status(200).json({ valid: true });
});
 
 
// Function to store OTP for a specific email address
function storeOTP(email, otp) {
  otpStorage[email] = otp;
}
 
// Function to retrieve OTP for a specific email address
function getOTP(email) {
  return otpStorage[email];
}
 
// Function to generate OTP
function generateOTP() {
  const length = 4;
  const characters = '0123456789';
  let otp = '';
 
  for (let i = 0; i < length; i++) {
    const index = Math.floor(Math.random() * characters.length);
    otp += characters[index];
  }
 
  return otp;
}

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
 