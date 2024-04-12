import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-home-buy2-details',
  templateUrl: './home-buy2-details.component.html',
  styleUrls: ['./home-buy2-details.component.css']
})
export class HomeBuy2DetailsComponent implements OnInit {
 
  constructor(private router:Router) { }
 
  ngOnInit(): void {
  }
 
  acceptAndProceed(): void {
    this.router.navigate(['/customer-details']);
  }
}