import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vehicle-buy1-details',
  templateUrl: './vehicle-buy1-details.component.html',
  styleUrls: ['./vehicle-buy1-details.component.css']
})
export class VehicleBuy1DetailsComponent implements OnInit {
  constructor() { }
 
  ngOnInit(): void {
  }
 
  acceptAndProceed(): void {
    // Implement your logic for accepting the policy and proceeding
    console.log('Policy accepted and proceeding...');
    // You can navigate to another page or perform any other action here
  }
}


