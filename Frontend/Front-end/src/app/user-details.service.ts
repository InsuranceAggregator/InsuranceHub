import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {
  private apiUrl = 'http://localhost:8760/policyholder/policyholders/';
 
  constructor(private http: HttpClient) { }
 
  submitUserDetails(formData: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, formData);
  }
}