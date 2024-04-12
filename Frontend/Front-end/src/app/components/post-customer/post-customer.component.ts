import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';
 
@Component({
  selector: 'app-post-customer',
  templateUrl: './post-customer.component.html',
  styleUrls: ['./post-customer.component.css']
})
export class PostCustomerComponent implements OnInit {
 
  postCustomerForm!: FormGroup;
  submitted = false; // Add this variable to track form submission
 
  constructor(private customerService: CustomerService,
    private fb: FormBuilder,
    private router: Router) { }
 
  ngOnInit() {
    this.postCustomerForm = this.fb.group({
      policyNumber: [null, [Validators.required, this.policyNumberValidator]],
      type: [null, [Validators.required]],
      premium: [null, [Validators.required, Validators.pattern('^[0-9]*$')]],
      status: [null, [Validators.required, this.statusValidator]],
    });
  }
 
  postCustomer() {
    this.submitted = true; // Set submitted to true when the form is submitted
    if (this.postCustomerForm.invalid) {
      return; // If the form is invalid, do not proceed with submission
    }
    console.log(this.postCustomerForm.value);
    alert('Post is successful');
    this.customerService.postCustomer(this.postCustomerForm.value).subscribe((res) => {
      console.log(res);
      this.router.navigateByUrl("/");
    });
  }
 
  // Custom validator for policyNumber
  policyNumberValidator(control: any) {
    const policyNumberRegex = /^[a-zA-Z0-9]*$/;
    if (control.value && !policyNumberRegex.test(control.value)) {
      return { 'invalidPolicyNumber': true };
    }
    return null;
  }
 
  // Custom validator for status
  statusValidator(control: any) {
    const validStatuses = ['Active', 'Pending', 'Cancelled', 'InProgress'];
    if (control.value && !validStatuses.includes(control.value)) {
      return { 'invalidStatus': true };
    }
    return null;
  }
}