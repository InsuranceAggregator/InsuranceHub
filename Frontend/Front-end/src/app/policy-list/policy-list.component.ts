import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../insurance.service';

@Component({
  selector: 'app-policy-list',
  templateUrl: './policy-list.component.html',
  styleUrls: ['./policy-list.component.scss']
})
export class PolicyListComponent implements OnInit {

  policies: any[] = [];

  constructor(private insuranceService: InsuranceService) { }

  ngOnInit(): void {
    this.loadPolicies();
  }

  loadPolicies(): void {
    this.insuranceService.getAllPolicies()
    .subscribe(data => {
      this.policies = data;
    }, error => {
      console.error('Error loading policies:', error);
    });
  }

  updatePolicy(policy: any): void {
    // Implement logic to navigate to update policy component with policy data
  }

  deletePolicy(id: number): void {
    this.insuranceService.deletePolicy(id).subscribe(() => {
      this.loadPolicies();
    });
  }
}
