import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
 
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:3000'; // Update with your backend API URL
 
  constructor(private http: HttpClient) { }
 
 /* checkEmail(email: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/checkEmail`, { email });
  }*/
 
  sendOTP(email: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/sendEmail`, { to: email, subject: 'Forgot Password OTP' })
      .pipe(
        catchError(this.handleError)
      );
  }
 
  verifyOTP(otp: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/verifyOTP`, { otp })
      .pipe(
        catchError(this.handleError)
      );
  }
 
  private handleError(error: any) {
    console.error('API Error:', error);
    return throwError('Something went wrong; please try again later.');
  }
}