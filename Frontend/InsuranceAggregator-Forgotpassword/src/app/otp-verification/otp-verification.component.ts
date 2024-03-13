import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-otp-verification',
  templateUrl: './otp-verification.component.html',
  styleUrl: './otp-verification.component.css'
})
export class OtpVerificationComponent {
  otp: string = '';

  constructor(private router: Router) { }

  verifyOTP() {
    // Add your logic to verify OTP here
    
    // For example, after verifying the OTP, navigate to a success page
    this.router.navigate(['/password-reset-success']);
  }

}
