import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';
import { UserDetailsService } from '../user-details.service';
 
@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent {
      // Initialize variables for start and end dates
  startDate: string | null = null;
  endDate: string | null = null;
  submitted = false;
  constructor(private userDetailsService: UserDetailsService,private router: Router,private datePipe: DatePipe) {
    const currentDate = new Date();
        this.startDate = this.datePipe.transform(currentDate, 'yyyy-MM-dd');
        const nextYearDate = new Date(currentDate.getFullYear() + 1, currentDate.getMonth(), currentDate.getDate());
        this.endDate = this.datePipe.transform(nextYearDate, 'yyyy-MM-dd');
   }
 
  onSubmit(form: NgForm) {
    this.submitted = true;
    if (form.valid) {
     
       // 1. Capture the form data
       const formData = form.value;

       // 2. Navigate to the payment gateway page
       this.router.navigate(['/paymentGateway'], { state: { formData } });
    } else {
      console.log('Form is invalid.');
      alert("Check the errors")
    }
  }
}
