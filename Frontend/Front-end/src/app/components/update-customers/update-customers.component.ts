import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';


@Component({
  selector: 'app-update-customers',
  templateUrl: './update-customers.component.html',
  styleUrls: ['./update-customers.component.css']
})
export class UpdateCustomersComponent implements OnInit {

  updateCustomerForm!: FormGroup;
  submitted = false;
  id: number = this.activatedRoute.snapshot.params["id"];

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private service: CustomerService,
              private fb: FormBuilder) {}

  ngOnInit() {
    this.updateCustomerForm = this.fb.group({
      policyNumber: [null], // No validators for readonly fields
      type: [null], // No validators for readonly fields
      premium: [null, [Validators.required, Validators.pattern('^[0-9]*$')]],
      status: [null, [Validators.required, this.statusValidator]],
    });
    this.getCustomerById();
  }
  
  getCustomerById() {
    this.service.getCustomerById(this.id).subscribe((res) => {
      console.log(res);
      // Assuming that you need to patch the retrieved data into the form
      this.updateCustomerForm.patchValue(res); // Patch the retrieved data to the form
    });
  }

  updateCustomer() {
    this.service.updateCustomer(this.id, this.updateCustomerForm.value).subscribe((res: any) => {
      console.log(res);
      if(res.id !=null){
        this.router.navigateByUrl("");
      }
    });
  }

  statusValidator(control: any) {
    const validStatuses = ['Active', 'Pending', 'Cancelled', 'InProgress', 'Completed']; // Updated with 'Completed'
    if (control.value && !validStatuses.includes(control.value)) {
      return { 'invalidStatus': true };
    }
    return null;
  }
}
