import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { HttpErrorResponse } from '@angular/common/http';
import { UserService } from '../user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  submitted: boolean = false;
 
  constructor(private router: Router, private loginService: LoginService, private userService: UserService) {}
 
  get emailValid(): boolean {
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailRegex.test(this.email);
  }
 
  get passwordValid(): boolean {
    return !!this.password.trim();
  }
 
  login() {
    this.submitted = true;
    if (this.emailValid && this.passwordValid) {
      this.loginService.login(this.email, this.password)
        .subscribe(
          response => {
            console.log('Login response:', response);
            if (response.message === 'Login Successful') {
              alert("Login Successful");
              this.userService.setEmail(this.email);
              this.router.navigate(['/homepage']);
            } 
            
            else if
             (response.message === 'Invalid email or password.') {
                alert("Invalid email or password.");
              } else if(response.message === 'Invalid Credentials'){
                alert("New user not yet registered.");
              } 
            
          },
          error => {
            console.error('Login error:', error);
            if (error instanceof HttpErrorResponse && error.status === 401) {
              alert("New user not yet registered/Invalid credentials.");
            } else {
              alert("An error occurred. Please try again later.");
            }
          }
        );
    }
  }
 
  forgotPassword() {
    if (this.emailValid) {
      console.log('Implementing forgot password functionality for:', this.email);
    }
  }
}
