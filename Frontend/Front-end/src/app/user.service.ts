import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
private userEmail: string='';
  constructor() { }

  // Example method to get email
  getEmail(): string {
    // Implement your logic to get the email here
    return this.userEmail;
  }

  // Example method to set email
  setEmail(email: string): void {
    // Implement your logic to set the email here
    console.log('Email set:', email);
    this.userEmail=email;
  }
}
