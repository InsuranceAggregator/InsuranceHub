import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Router } from '@angular/router';
import { UserDetailsService } from '../user-details.service';
 
@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent {
  submitted = false;
  constructor(private userDetailsService: UserDetailsService,private router: Router) { }
 
  onSubmit(form: NgForm) {
    this.submitted = true;
    if (form.valid) {
     
      this.userDetailsService.submitUserDetails(form.value).subscribe(
        response => {
         
          console.log('Form data submitted successfully:', response);
          this.router.navigate(['/paymentGateway']);
        },
        error => {
         
          console.error('Error submitting form data:', error);
         
        }
      );
    } else {
      console.log('Form is invalid.');
      alert("Check the errors")
    }
  }
}
