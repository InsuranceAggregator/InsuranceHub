import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-vehicle-buy1-details',
  templateUrl: './vehicle-buy1-details.component.html',
  styleUrls: ['./vehicle-buy1-details.component.css']
})
export class VehicleBuy1DetailsComponent implements OnInit {
  constructor(private router:Router) { }
 
  ngOnInit(): void {
  }
 
 
  acceptAndProceed(): void {
    this.router.navigate(['/customer-details'],{ skipLocationChange: true });
  }
}