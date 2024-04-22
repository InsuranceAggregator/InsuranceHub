import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {

  loginObj: any = {
    email: '',
    password: ''
  };
  
  constructor(private router: Router) {}

  OnLogin() {
    if (this.loginObj.email === 'admin@gmail.com' && this.loginObj.password === 'admin@123') {
      alert('Login Successful...!');
      this.router.navigate(['/admin-dashboard']);
    } else {
      alert('Wrong credentials');
    }
    return false;  // Prevent default form submission
  }
}
