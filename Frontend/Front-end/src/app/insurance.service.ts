import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InsuranceService {

  private baseUrl = 'http://localhost:8100/insurance'; // Update with your backend URL

  constructor(private http: HttpClient) { }

  getAllPolicies(): Observable<any> {
    return this.http.get(`${this.baseUrl}/plans`);
  }

  addPolicy(policy: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/plans`, policy);
  }

  updatePolicy(id: number, policy: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/plans/${id}`, policy);
  }

  deletePolicy(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/plans/${id}`);
  }
}
