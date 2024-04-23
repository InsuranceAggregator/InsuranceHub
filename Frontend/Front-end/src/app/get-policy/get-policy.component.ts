import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../insurance.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-policy',
  templateUrl: './get-policy.component.html',
  styleUrls: ['./get-policy.component.css']
})
export class GetPolicyComponent implements OnInit {

  policies: any[] = [];


  constructor(private insuranceService: InsuranceService, private router: Router) { }

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
    const policyId = policy.id;
    // Implement logic to navigate to update policy component with policy data
    this.router.navigate(['/update-policy/',policyId]);
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
