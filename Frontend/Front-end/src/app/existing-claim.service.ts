import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExistingClaimService {
  private baseUrl = 'http://localhost:8760/existingclaim/claims/';

  constructor(private http: HttpClient) { }

  getExistingClaims(email: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}existing/${email}`);
  }
}
