import { Component, OnInit } from '@angular/core';
/*import { HealthInsuranceComponent } from '../policies/health-insurance/health-insurance.component';*/
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
 
  constructor(private router:Router){
 
  }
  ngOnInit(): void {
    console.log('HomepageComponent initialized');
  }
 
  
    navigateToDataDisplay() {
      // Navigate to the data display component
      this.router.navigate(['/data-display']);
    }
    navigateToHomeInsurance(): void {
      // Navigate to the root route, which is mapped to GetAllCustomersComponent
      this.router.navigate(['/getallcustomers']);
    }
    navigateTocontactus(): void {
      // Navigate to the root route, which is mapped to GetAllCustomersComponent
      this.router.navigate(['/customer-support']);
    }
}
function ngOnInit() {
  throw new Error('Function not implemented.');
}
 