import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  
  form: any = {}; // Object to hold form data
  submitted: boolean = false; // Flag to track form submission status

  constructor(private router: Router) {}

  // Function to handle form validation
  validateForm(): void {
    this.submitted = true; // Set form submission status to true
    console.log('Form validation triggered.');

    // Your validation logic goes here
    // For simplicity, we assume all fields are required
    if (!this.form.name || this.form.name.length < 3) {
      console.log('Name validation failed: Name is required and must contain at least 3 characters.');
    } 
    if (!this.form.mobile || !/^[1-9]{1}[0-9]{9}$/.test(this.form.mobile)) {
      console.log('Mobile number validation failed: Mobile number is required and must be 10 digits.');
    } 
    if (!this.form.email || !/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test(this.form.email)) {
      console.log('Email validation failed: Email is required and must be in a valid format.');
    } 
    if (!this.form.password || !/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(this.form.password)) {
      console.log('Password validation failed: Password is required and must contain at least one number, one uppercase, one lowercase letter, and 8 or more characters.');
    } 
    if (!this.form.confirmPassword || this.form.password !== this.form.confirmPassword) {
      console.log('Confirm Password validation failed: Confirm Password must match the Password.');
    }
  }

  // Function to handle form submission
  register(): void {
    this.validateForm(); // Validate the form
  
    if (this.submitted && this.form.name && this.form.mobile && this.form.email && this.form.password && this.form.confirmPassword && this.form.password === this.form.confirmPassword) {
      console.log('Form submission successful. User registered successfully:', this.form);
  
      // Display success alert message
      alert('Registration successful!');
  
      // After successful registration, you can navigate to another page
      // For example:
      this.router.navigate(['/login']); // Redirect to login page
    } else {
      console.log('Form submission failed. Please check the form for errors.');
  
      // Display error alert message
      alert('Form submission failed. Please check the form for errors.');
      
      if (this.form.password !== this.form.confirmPassword) {
        alert('Password and Confirm Password do not match.');
      }
    }
  }
  
  
}
