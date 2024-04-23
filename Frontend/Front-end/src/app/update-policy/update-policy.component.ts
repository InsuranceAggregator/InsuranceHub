import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InsuranceService } from '../insurance.service';

@Component({
  selector: 'app-update-policy',
  templateUrl: './update-policy.component.html',
  styleUrls: ['./update-policy.component.css']
})
export class UpdatePolicyComponent implements OnInit {
  policy: any = {
    policyName: '',
    description: '',
    premium: null,
    policyType: ''
  };

  constructor(private insuranceService: InsuranceService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.loadPolicy(id);
  }

  loadPolicy(id: number): void {
    this.insuranceService.getPolicyById(id).subscribe((policy: any) => {
      this.policy = policy;
    }, error => {
      
    });
  }

  submitForm(): void {
    this.insuranceService.updatePolicy(this.policy.id, this.policy).subscribe(() => {
      this.router.navigate(['/get-policy']);
    }, error => {
      // Handle error
    });
  }
}
