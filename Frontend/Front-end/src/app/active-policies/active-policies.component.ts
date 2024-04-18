import { Component, OnInit } from '@angular/core';
import { PolicyService } from '../policy.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-active-policies',
  templateUrl: './active-policies.component.html',
  styleUrls: ['./active-policies.component.css']
})
export class ActivePoliciesComponent implements OnInit {
  activePolicies: any[] = [];

  constructor(private policyService: PolicyService, private userService: UserService) { }

  ngOnInit() {
    this.loadActivePolicies();
  }

  loadActivePolicies() {
    const userEmail = this.userService.getEmail();
    if (userEmail) {
      this.policyService.getActivePolicies(userEmail)
        .subscribe(data => {
          this.activePolicies = data;
        }, error => {
          console.error('Error loading active policies:', error);
        });
    } else {
      console.error('Email not available');
    }
  }
}
