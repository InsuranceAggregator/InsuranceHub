import { Component } from '@angular/core';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  submitted: boolean = false;
 
  get emailValid(): boolean {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailRegex.test(this.email);
  }
 
  get passwordValid(): boolean {
    return !!this.password.trim();
  }
 
  constructor(private router: Router) {}

  login() {
    this.submitted = true;
    if (this.emailValid && this.passwordValid) {
      console.log('Logging in with:', this.email, 'and password:', this.password);
      this.router.navigate(['/dashboard']);
    }
  }
 
  forgotPassword() {
    if (this.emailValid) {
      // You can implement your logic here to handle forgot password functionality
      console.log('Implementing forgot password functionality for:', this.email);
    }
  }
}
