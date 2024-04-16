import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {
  private baseUrl = 'http://localhost:8096/policies/';

  constructor(private http: HttpClient) { }

  getActivePolicies(email: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}active/${email}`);
  }
}
