import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
 
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  insuranceData: Insurance[] = [];
 
  constructor(private http: HttpClient) { }
 
  ngOnInit(): void {
    this.fetchInsuranceData();
  }
 
  fetchInsuranceData(): void {
    // Simulating fetching data from backend API
    // Replace this with actual API call
    this.insuranceData = [
      { id: 1, policyNumber: "H123456", type: "Home", premium: 500.00, status: "Active" },
      { id: 2, policyNumber: "A789012", type: "Auto", premium: 300.00, status: "Expired" },
      { id: 3, policyNumber: "L345678", type: "Life", premium: 1000.00, status: "Active" }
    ];
  }
}
 
interface Insurance {
  id: number;
  policyNumber: string;
  type: string;
  premium: number;
  status: string;
}