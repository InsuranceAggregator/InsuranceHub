import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-home-buy1-details',
  templateUrl: './home-buy1-details.component.html',
  styleUrls: ['./home-buy1-details.component.css']
})
export class HomeBuy1DetailsComponent implements OnInit {
 
  constructor(private router:Router) { }
 
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
 
  acceptAndProceed(): void {
    this.router.navigate(['/customer-details']);
  }
}