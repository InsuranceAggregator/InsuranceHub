import { Component, OnInit } from '@angular/core';
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
    throw new Error('Method not implemented.');
  }
 
 
    navigateToDataDisplay() {
      // Navigate to the data display component
      this.router.navigate(['/data-display']);
    }
    navigateToHomeInsurance(): void {
      // Navigate to the root route, which is mapped to GetAllCustomersComponent
      this.router.navigate(['/customer']);
    }
    navigateTocontactus(): void {
      // Navigate to the root route, which is mapped to GetAllCustomersComponent
      this.router.navigate(['/customer-support']);
    }
    navigateToHomebuy1(): void{
      this.router.navigate(['/home-buy1']);
    }
    navigateToHomebuy2(): void{
      this.router.navigate(['/home-buy2']);
    }
    navigateToVehiclebuy1(): void{
      this.router.navigate(['/vehicle-buy1']);
    }
    navigateToVehiclebuy2(): void{
      this.router.navigate(['/vehicle-buy2']);
    }
}
 
 