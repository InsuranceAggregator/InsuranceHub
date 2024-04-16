import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class LoginService {
 
  private baseUrl = 'http://localhost:8084/api/v';
 
  constructor(private http: HttpClient) { }
 
  login(email: string, password: string): Observable<any> {
    const url = `${this.baseUrl}/login`;
    const body = { email, password };
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<any>(url, body, { headers });
  }
}