import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from './models/contact';
 // Import the Contact model

@Injectable({
  providedIn: 'root'
})
export class AdminContactService {
  private baseUrl = 'http://localhost:8094/api/contacts';

  constructor(private http: HttpClient) { }

  getAllContactMessages(): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${this.baseUrl}`);
  }

  deleteContactMessage(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
