import { Component } from '@angular/core';
/*import { HealthInsuranceComponent } from '../policies/health-insurance/health-insurance.component';*/
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {
 
  constructor(private router:Router){

  }
  navigateToAnotherPage(): void {
    this.router.navigate(['/home']);
  }
}
