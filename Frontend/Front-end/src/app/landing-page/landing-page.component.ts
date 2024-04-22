import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingpageComponent implements OnInit {
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
    sessionStorage.setItem('log', '0');
    window.location.reload();
  }

  navigateToAdminLogin() {
    this.router.navigate(['/admin-login']); // Navigate to Admin login page
  }

  UserLogin() {
    this.router.navigate(['/login']); // Navigate to User login page
  }
}
