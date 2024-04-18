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
      this.router.navigate(['/data-display'],{ skipLocationChange: true });
    }
    navigateToHomeInsurance(): void {
      // Navigate to the root route, which is mapped to GetAllCustomersComponent
      this.router.navigate(['/customer'],{ skipLocationChange: true });
    }
    navigateTocontactus(): void {
      // Navigate to the root route, which is mapped to GetAllCustomersComponent
      this.router.navigate(['/customer-support'],{ skipLocationChange: true });
    }
    navigateToHomebuy1(): void{
      this.router.navigate(['/home-buy1'],{ skipLocationChange: true });
    }
    navigateToHomebuy2(): void{
      this.router.navigate(['/home-buy2'],{ skipLocationChange: true });
    }
    navigateToVehiclebuy1(): void{
      this.router.navigate(['/vehicle-buy1'],{ skipLocationChange: true });
    }
    navigateToVehiclebuy2(): void{
      this.router.navigate(['/vehicle-buy2'],{ skipLocationChange: true });
    }
}
 
 