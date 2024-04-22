import { Component, OnInit } from '@angular/core';
import { InsuranceService } from '../insurance.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-policy',
  templateUrl: './add-policy.component.html',
  styleUrls: ['./add-policy.component.css']
})
export class AddPolicyComponent implements OnInit {
  policyName: string = '';
  description: string = '';
  premium: number | null = null;
  policyType: string = '';
  
  constructor(private insuranceService: InsuranceService, private router: Router) {}

  ngOnInit(): void {}
  
  submitForm(): void {
    const policy = {
      policyName: this.policyName,
      description: this.description,
      premium: this.premium,
      policyType: this.policyType
    };
    
    this.insuranceService.addPolicy(policy).subscribe(() => {
      this.router.navigate(['/get-policy']);
      // Handle success, maybe navigate to policy list component
    }, error => {
      // Handle error
    });
  }
}
