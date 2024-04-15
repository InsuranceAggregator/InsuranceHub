import { Component, OnInit } from '@angular/core';
import { PasswordResetService } from '../password-reset.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';
 
 
 
@Component({
  selector: 'app-password-reset-success',
  templateUrl: './password-reset-success.component.html',
  styleUrls: ['./password-reset-success.component.css'] // Note the correct property name and array syntax
})
export class PasswordResetSuccessComponent implements OnInit {
  email: string = '';
  newPassword: string = '';
  confirmPassword: string = '';
  errorMessage: string = ''; // Added errorMessage property
 
  constructor(private passwordResetService: PasswordResetService, private route: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    // Retrieve email from route parameters
    this.route.queryParams.subscribe(params => {
      this.email = params['email'];
      console.log('Email received in PasswordResetSuccessComponentt:', this.email);
    });
  }
 
  resetPassword(form: NgForm) {
    console.log('Reset password method called'); // Add this line to verify method invocation
 
    if (form.valid) {
      console.log('Form is valid'); // Add this line to verify form validity
 
      if (this.newPassword !== this.confirmPassword) {
        console.log('Passwords do not match'); // Log message for passwords not matching
        this.errorMessage = 'Passwords do not match';
        alert('Passwords do not match');
        return;
      }
 
      const email = this.passwordResetService.getResetEmail();
      console.log('Email retrieved from PasswordResetServicee:', email); // Add this line to log the retrieved email address
      if (!email) {
        console.log('Email not found'); // Log message for email not found
        this.errorMessage = 'Email not found';
        return;
      }
      console.log('Email found:', email); // Log message for email found
     
     
      this.passwordResetService.resetPassword(email, this.newPassword).subscribe(
        () => {
          console.log('Password reset successfully');
          alert('Password reset successfully');
          // Handle success, e.g., navigate to success page
          this.router.navigate(['/login'],{ skipLocationChange: true });
        },
        (error) => {
          console.error('Error resetting password:', error);
          //this.errorMessage = 'Failed to reset password. Please try again later.';
          if (error.error && error.error.error === 'User not found with the given email') {
            this.errorMessage = 'An error occurred:' + error.error.message;
            alert('User not found with the given email');
          } else {
            this.errorMessage = 'Backend returned code ' + error.status + ', body was: ' + error.error;
            alert('Failed to reset password. Please try again later.');
          }
        }
      );
    } else {
      console.log('Form is not valid'); // Add this line to verify if the form is not valid
      alert('Form is not valid');
    }
  }
  togglePasswordVisibility(fieldId: string): void {
    const passwordInput = document.getElementById(fieldId) as HTMLInputElement;
    if (passwordInput.type === 'password') {
      passwordInput.type = 'text';
    } else {
      passwordInput.type = 'password';
    }
  }
 
}