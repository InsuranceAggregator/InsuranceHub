// forgot-password.component.ts

import { Component } from '@angular/core';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {
  email: string = '';
  otp: string = '';
  otpVerified: boolean = false;
  passwordReset: boolean = false;

  sendOTP() {
    // Simulate sending OTP via email (you would typically call an API here)
    // For simplicity, let's assume OTP is 123456
    const generatedOTP = '123456';

    // Display OTP verification form
    this.otpVerified = false;

    // TODO: Send OTP via email or any other method
    // Example: this.authService.sendOTP(this.email, generatedOTP);

    console.log('OTP sent:', generatedOTP);
  }

  verifyOTP() {
    // TODO: Call API to verify OTP
    // Example: this.authService.verifyOTP(this.email, this.otp);

    // For simplicity, let's assume OTP is 123456
    const correctOTP = '123456';

    if (this.otp === correctOTP) {
      this.otpVerified = true;
    } else {
      alert('Invalid OTP. Please try again.');
    }
  }

  // TODO: Implement password reset functionality
  // Example: this.authService.resetPassword(this.email, newPassword);
}
