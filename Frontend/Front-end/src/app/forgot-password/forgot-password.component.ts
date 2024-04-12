import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EmailService } from '../email.service';
import { ApiService } from '../api.service'; // Import the ApiService for making HTTP requests
import { PasswordResetService } from '../password-reset.service';
 
@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {
  email: string = '';
  otp: string = '';
  otpVerified: boolean = false;
  //sendOtpEnabled: boolean = false; // Variable to enable/disable the "Send OTP" button
 
  constructor(private router: Router, private emailService: EmailService, private apiService: ApiService, private passwordResetService: PasswordResetService) {}
 /* checkEmail() {
    // Check if email exists in the database
    this.apiService.checkEmail(this.email).subscribe(
      response => {
        console.log('Email verification response:', response);
        if (response && response.exists) {
          // If email exists, enable the "Send OTP" button
          this.sendOtpEnabled = true;
        } else {
          // If email does not exist, disable the "Send OTP" button
          this.sendOtpEnabled = false;
          // Handle case where email does not exist, e.g., display an error message to the user
        }
      },
      error => {
        console.error('Error verifying email:', error);
        // Handle error, e.g., display an error message to the user
      }
    );
  }*/
  onSubmit() {
    console.log('Email to be set:', this.email); // Add this log
    // Validate email if needed
    this.passwordResetService.setResetEmail(this.email);
    console.log('Email set in PasswordResetService:', this.email); // Add this line to log the email address being set
    // Send request to backend to send OTP or whatever is your flow
    this.sendOTP();
  }
  sendOTP() {
    // Send email with OTP
    const emailData = {
      to: this.email,
      subject: 'Forgot Password OTP',
      text: '' // Empty text to be filled with generated OTP in backend
    };
 
    this.emailService.sendEmail(emailData).subscribe(
      response => {
        console.log('Email sent successfully:', response);
        // Handle success, e.g., display a success message to the user
        this.router.navigate(['/otp'], { queryParams: { email: this.email } });
      },
      error => {
        console.error('Error sending email:', error);
        // Handle error, e.g., display an error message to the user
      }
    );
 
    // Display OTP verification form
    this.otpVerified = false;
  }
}