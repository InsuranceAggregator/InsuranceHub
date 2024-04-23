import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = ["http://localhost:8760/homeinsuranceplan"]; // Corrected BASIC_URL as string

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
    //updateCustomer: any;

  constructor(private http: HttpClient) { }

  postCustomer(customer: any): Observable<any> {
    return this.http.post (BASIC_URL + "/home-insurance/plans", customer);
  }

   getAllCustomer():Observable<any>{
       return this.http.get(BASIC_URL+ "/home-insurance/plans");
   }
   getCustomerById(id: number):Observable<any>{
        return this.http.get(BASIC_URL+ "/home-insurance/plans/" +id);   

   }
   updateCustomer(id: number, customer: any): Observable<any>{
    return this.http.put(BASIC_URL+ "/home-insurance/plans/" +id,customer);  
   }
}
