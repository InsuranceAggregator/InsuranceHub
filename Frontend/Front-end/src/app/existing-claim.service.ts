import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExistingClaimService {
  private baseUrl = 'http://localhost:8100/claims/';

  constructor(private http: HttpClient) { }

  getExistingClaims(email: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}existing/${email}`);
  }
}
