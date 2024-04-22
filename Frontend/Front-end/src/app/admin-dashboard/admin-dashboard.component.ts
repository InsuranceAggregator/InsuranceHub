import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  isLoggedIn: boolean | undefined;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.isUserLoggedIn();
  }

  isUserLoggedIn() {
    if (sessionStorage.getItem('log') === '1') {
      this.isLoggedIn = true;
    } else {
      this.isLoggedIn = false;
    }
  }

  logout() {
    this.router.navigate(['/landing-page']);
  }
  
  navigateToInsurance() {
    this.router.navigate(['/get-policy']);
  }
  
  navigateToUserDetails() {
    this.router.navigate(['/user-details']);
  }

  navigateToAdminClaim(){
    this.router.navigate(['/admin-claim']);
  }

  navigateToAdminContactUs() {
    this.router.navigate(['/admin-support']);
  }

  
  navigateToHomeInsurance() {
    this.router.navigate(['/getallcustomers']); 
  }

}
