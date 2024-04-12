// contact.service.ts
 
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private baseUrl = 'http://localhost:8080/api/contacts'; // Adjusted backend URL
 
  constructor(private http: HttpClient) { }
 
  submitContactForm(data: any): Observable<any> {
    return this.http.post<any>(this.baseUrl, data);
  }
}