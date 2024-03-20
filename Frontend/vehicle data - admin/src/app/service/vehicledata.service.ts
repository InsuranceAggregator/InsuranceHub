import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL="http://localhost:8080"
@Injectable({
  providedIn: 'root'
})
export class VehicledataService {

  constructor(private http: HttpClient) { }

  postVehicledata(vehicledata: any): Observable<any>{
    return this.http.post(BASIC_URL + "/vehicle-insurance/plans" , vehicledata);
  }
}
