import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { ExistingClaimService } from '../existing-claim.service';

@Component({
  selector: 'app-existing-claims',
  templateUrl: './existing-claims.component.html',
  styleUrls: ['./existing-claims.component.css']
})
export class ExistingClaimsComponent implements OnInit {
existingClaims: any[] = [];

constructor(private existingClaimService: ExistingClaimService, private userService: UserService) { }

ngOnInit() {
  this.loadExistingClaims();
}

loadExistingClaims() {
  const userEmail = this.userService.getEmail();
  if (userEmail) {
    this.existingClaimService.getExistingClaims(userEmail)
      .subscribe(data => {
        this.existingClaims = data;
      }, error => {
        console.error('Error loading existing claims:', error);
      });
  } else {
    console.error('Email not available');
  }
}
}
