
import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
 
@Injectable({

  providedIn: 'root'

})

export class BackendDataService {

  private apiUrl = 'http://localhost:8080/insurance/plans';
 
  constructor(private http: HttpClient) { }
 
  getData(): Observable<any> {

    return this.http.get<any>(this.apiUrl);

  }
 
  searchByPolicyName(policyName: string): Observable<any> {

    return this.http.get(`${this.apiUrl}/search?policyName=${policyName}`);

  }

}
