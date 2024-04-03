import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EmailService {
  private baseUrl = 'http://localhost:3000'; // Replace with your backend URL

  constructor(private http: HttpClient) { }

  sendEmail(emailData: any) {
    return this.http.post<any>(`${this.baseUrl}/sendEmail`, emailData);
  }
}
