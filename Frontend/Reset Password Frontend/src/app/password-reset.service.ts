import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Resolve } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class EmailResolver implements Resolve<string> {
  constructor(private passwordResetService: PasswordResetService) {}

  resolve(): Observable<string> | Promise<string> | string {
    return this.passwordResetService.getResetEmail();
  }
}
@Injectable({ providedIn: 'root' })
export class PasswordResetService {
 private resetEmail: string = '';
 private resetPasswordUrl = 'http://localhost:8080/api/reset-password';
  constructor(private http: HttpClient) { }

  setResetEmail(email: string) {
    console.log('Email to be set:', email); // Add this log
    this.resetEmail = email;
  }

  getResetEmail(): string {
    const email = this.resetEmail;
    console.log('Email retrieved:', email); // Add this log
    return this.resetEmail;
  }

  resetPassword(email: string, password: string) {
    return this.http.put(this.resetPasswordUrl, { email, password });
  }

}
