import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-policy-details',
  templateUrl: './policy-details.component.html',
  styleUrls: ['./policy-details.component.css']
})
export class PolicyDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  acceptAndProceed(): void {
    // Implement your logic for accepting the policy and proceeding
    console.log('Policy accepted and proceeding...');
    // You can navigate to another page or perform any other action here
  }
}
