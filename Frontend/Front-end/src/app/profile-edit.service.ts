

import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
 
@Injectable({

  providedIn: 'root'

})

export class ProfileEditService {

  private baseUrl = 'http://localhost:8084/profiles/';
 
  constructor(private http: HttpClient) { }
 
  getUserProfileByEmail(email: string): Observable<any> {

    return this.http.get<any>(`${this.baseUrl}${email}`);

  }
 
  updateUserProfile(email: string, profileData: any): Observable<any> {

    return this.http.put<any>(`${this.baseUrl}${email}`, profileData);

  }

}