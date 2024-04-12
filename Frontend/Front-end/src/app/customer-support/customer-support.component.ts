// customer-support.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ContactService } from '../service/support/contact.service';

 
 
@Component({
  selector: 'app-customer-support',
  templateUrl: './customer-support.component.html',
  styleUrls: ['./customer-support.component.css']
})
export class CustomerSupportComponent {
  

  name: string = '';
  email: string = '';
  phoneNumber: string = '';
  message: string = '';
  errorMessage: string = '';
 
  constructor(
    private router: Router,
    private contactService: ContactService
  ) { }

  ngOnInit(): void {
  }
  navigateToHomePage() {
    this.router.navigate(['/homepage']);
  }
   
 
  onSubmit(): void {
    if (this.validateForm()) {
      this.contactService.submitContactForm({
        name: this.name,
        email: this.email,
        phoneNumber: this.phoneNumber,
        message: this.message
      })
      .subscribe(
        response => {
          this.validateForm()
          if (!this.name.trim() || !this.email.trim() || !this.phoneNumber.trim() || !this.message.trim())
          console.log('Form submitted successfully!',response);
          alert('Form submitted successfully!');
          this.router.navigate(['/homepage']);
          
        },
        error => {
          console.error('Form submission failed:', error);
          alert('Form submission failed. Please try again later.');
        }
      );
    } else {
      console.error('Form validation failed:', this.errorMessage);
      alert('Form submission failed. Please check the form for errors.');
    }
  }
 
  private validateForm(): boolean {
    // Add your validation logic here
    // For simplicity, assuming all fields are required
    if (!this.name.trim() || !this.email.trim() || !this.phoneNumber.trim() || !this.message.trim()) {
      this.errorMessage = 'All fields are required.';
      return false;
    }
    return true;
  }
}