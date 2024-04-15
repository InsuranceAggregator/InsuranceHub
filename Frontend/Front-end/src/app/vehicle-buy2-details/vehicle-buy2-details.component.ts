import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-vehicle-buy2-details',
  templateUrl: './vehicle-buy2-details.component.html',
  styleUrls: ['./vehicle-buy2-details.component.css']
})
export class VehicleBuy2DetailsComponent implements OnInit {
  constructor(private router:Router) { }
 
 
  ngOnInit(): void {
  }
 
  acceptAndProceed(): void {
    this.router.navigate(['/customer-details'],{ skipLocationChange: true });
  }
}