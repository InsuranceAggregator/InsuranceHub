import { Component, OnInit } from '@angular/core';
 
@Component({
  selector: 'app-home-buy1-details',
  templateUrl: './home-buy1-details.component.html',
  styleUrls: ['./home-buy1-details.component.css']
})
export class HomeBuy1DetailsComponent implements OnInit {
 
  constructor() { }
 
  ngOnInit(): void {
  }
 
  acceptAndProceed(): void {
    // Implement your logic for accepting the policy and proceeding
    console.log('Policy accepted and proceeding...');
    // You can navigate to another page or perform any other action here
  }
}