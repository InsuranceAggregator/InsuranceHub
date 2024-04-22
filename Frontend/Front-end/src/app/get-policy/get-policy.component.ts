import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../insurance.service';

@Component({
  selector: 'app-get-policy',
  templateUrl: './get-policy.component.html',
  styleUrls: ['./get-policy.component.css']
})
export class GetPolicyComponent implements OnInit {

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
      console.error('Error loading active policies:', error);
    });
  }

  updatePolicy(policy: any): void {
    // Implement logic to navigate to update policy component with policy data
  }

  deletePolicy(id: number): void {
    this.insuranceService.deletePolicy(id)
    .subscribe(() => {
      this.loadPolicies();
    }, error => {
      console.error('Error loading', error);
    });
  }
}
