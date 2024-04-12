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

  constructor(private router: Router, private http: HttpClient) {}

  // Function to handle form validation
  validateForm(): void {
    this.submitted = true; // Set form submission status to true
    console.log('Form validation triggered.');

    // Your validation logic goes here
    // For simplicity, we assume all fields are required
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
      alert('Registration successful!');
      this.router.navigate(['/login']); // Redirect to login page after successful registration
      // Send registration data to backend
      this.http.post<any>('http://localhost:8082/api/v/register', {
        name: this.form.name,
        mobilenumber: this.form.mobilenumber,
        email: this.form.email,
        password: this.form.password,
        confirmpassword: this.form.confirmpassword
      }).subscribe(
        response => {
          console.log('Registration successful:', response);
          alert('Registration successful!');
         // this.router.navigate(['/login']); // Redirect to login page after successful registration
        },
        error => {
          console.error('Registration failed:', error);
         // alert('Registration failed. Please try again later.');
        }
      );
    } else {
      console.log('Form submission failed. Please check the form for errors.');

      // Display error alert message
      alert('Form submission failed. Please check the form for errors.');
      
      if (this.form.password !== this.form.confirmpassword) {
        alert('Password and Confirm Password do not match.');
      }
    }
  }  
}
