import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service'; // Adjust the path if needed
import { PasswordResetService } from '../password-reset.service';
 
@Component({
  selector: 'app-otp-verification',
  templateUrl: './otp-verification.component.html',
  styleUrls: ['./otp-verification.component.css']
})
export class OtpVerificationComponent  {
  otp: string = '';
  email: string = '';
 
  constructor(private router: Router, private route: ActivatedRoute, private apiService: ApiService, private passwordResetService: PasswordResetService) { }
 
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.email = params['email'];
      console.log('Email to be passed to PasswordResetSuccessComponent:', this.email);
      this.passwordResetService.setResetEmail(this.email);
    });
  }
  verifyOTP() {
    // Send OTP for verification
    this.apiService.verifyOTP(this.otp).subscribe(
      (response) => {
        console.log('OTP verification response:', response);
        if (response && response.valid !== undefined) {
          if (response.valid) {
            // If OTP is valid, display success message and navigate to the next page
            // If OTP is valid, navigate to the password-reset-success component with email parameter
          console.log('Email to be passed to PasswordResetSuccessComponent:', this.email); // Add this line
            alert('OTP verification successful');
            // If OTP is valid, navigate to the success page
            this.router.navigate(['/password-reset/reset-password'],{ skipLocationChange: true }) , { queryParams: { email: this.email } };
          } else {
            // If OTP is invalid, display an error message
            alert('Invalid OTP. Please try again.');
          }
        } else {
          // If response is not valid JSON, display an error message
          alert('An error occurred while verifying OTP. Please try again Later.');
        }
      },
      error => {
        console.error('Error verifying OTP:', error);
        // Handle error, e.g., display an error message to the user
        alert('An error occurred while verifying OTP. Please try again later.');
      }
    );
  }
}