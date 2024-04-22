import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateClaimService {

  private baseUrl = 'http://localhost:8100/claims/';

  constructor(private http: HttpClient) { }

  getAllExistingClaims(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}all`);
  }

  updateClaimByClaimNumber(claimNumber: string, updatedClaim: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}update/${claimNumber}`, updatedClaim);
  }
}
