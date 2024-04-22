import { Component } from '@angular/core';
import { UpdateClaimService } from '../update-claim.service';

@Component({
  selector: 'app-admin-claim',
  templateUrl: './admin-claim.component.html',
  styleUrls: ['./admin-claim.component.css']
})
export class AdminClaimComponent {

  existingClaims: any[] = [];

  constructor(private updateClaimService: UpdateClaimService) { }

  ngOnInit() {
    this.loadExistingClaims();
  }

  loadExistingClaims() {
    this.updateClaimService.getAllExistingClaims()
      .subscribe(data => {
        this.existingClaims = data;
      }, error => {
        console.error('Error loading existing claims:', error);
      });
  }

  submitForm(claimNumber: string) {
    const existingClaim = this.existingClaims.find(claim => claim.claimNumber === claimNumber);
    if (existingClaim) {
      this.updateClaimService.updateClaimByClaimNumber(claimNumber, existingClaim)
        .subscribe(updatedClaim => {
          console.log('Claim status updated successfully:', updatedClaim);
          alert('Claim status updated successfully');
          // Optionally, update the existingClaims array with the updated claim
        }, error => {
          console.error('Error updating claim status:', error);
          alert('Failed to update claim status');
        });
    } else {
      console.error('Claim not found with claimNumber:', claimNumber);
    }
  }
}
