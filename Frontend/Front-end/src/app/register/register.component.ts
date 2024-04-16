import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
 
@Component({
  selector: 'app-registration',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
 
  form: any = {}; // Object to hold form data
  submitted: boolean = false; // Flag to track form submission status
  emailExists: boolean = false; // Flag to track if email already exists
  errorMessage: string = ''; // Error message to display for email existence
 
  constructor(private router: Router, private http: HttpClient) {}
 
  // Function to handle form validation
  validateForm(): void {
    this.submitted = true; // Set form submission status to true
    console.log('Form validation triggered.');
 
    if (!this.form.name || this.form.name.length < 3) {
      console.log('Name validation failed: Name is required and must contain at least 3 characters.');
    }
    if (!this.form.mobilenumber || !/^[1-9]{1}[0-9]{9}$/.test(this.form.mobilenumber)) {
      console.log('Mobile number validation failed: Mobile number is required and must be 10 digits.');
    }
    if (!this.form.email || !/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test(this.form.email)) {
      console.log('Email validation failed: Email is required and must be in a valid format.');
    }
    if (!this.form.password || !/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(this.form.password)) {
      console.log('Password validation failed: Password is required and must contain at least one number, one uppercase, one lowercase letter, and 8 or more characters.');
    }
    if (!this.form.confirmpassword || this.form.password !== this.form.confirmpassword) {
      console.log('Confirm Password validation failed: Confirm Password must match the Password.');
    }
  }
 
  // Function to handle form submission
  register(): void {
    this.validateForm(); // Validate the form
 
    if (this.submitted && this.form.name && this.form.mobilenumber && this.form.email && this.form.password && this.form.confirmpassword && this.form.password === this.form.confirmpassword) {
      console.log('Form submission successful. User registered successfully:', this.form);
      // Send registration data to backend
      this.http.post<any>('http://localhost:8084/api/v/register', {
        name: this.form.name,
        mobilenumber: this.form.mobilenumber,
        email: this.form.email,
        password: this.form.password,
        confirmpassword: this.form.confirmpassword
      }).subscribe(
        response => {
          console.log('Registration response:', response);
          if (response && response.message === 'User Registration Successful') {
            console.log('Registration successful:', response);
            alert('Registration successful!');
            this.router.navigate(['/login']); // Redirect to login page after successful registration
          } else {
            console.error('Registration failed:', response);
            if (response && response.message === 'Email ID already exists') {
              // Email already exists
              this.emailExists = true;
              this.errorMessage = 'Email already exists';
            } else {
              // Other error occurred
              console.error('Registration failed:', response);
            }
          }
        },
        error => {
          console.error('Registration failed:', error);
          if (error.status === 409) {
            // Email already exists
            this.emailExists = true;
            this.errorMessage = 'Email already exists';
          } else {
            // Other error occurred
            console.error('Registration failed:', error);
          }
        }
      );
    } else {
       alert('Form submission failed. Please check the form for errors.');
     
      if (this.form.password !== this.form.confirmpassword) {
        alert('Password and Confirm Password do not match.');
      }
    }
  }  
}