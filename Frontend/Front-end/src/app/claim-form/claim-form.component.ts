import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service'; // Import UserService
import { Router } from '@angular/router';

@Component({
  selector: 'app-claim-form',
  templateUrl: './claim-form.component.html',
  styleUrls: ['./claim-form.component.css']
})
export class ClaimFormComponent implements OnInit {
  claimForm!: FormGroup;
  policyNumbers: string[] = []; // Array to store policy numbers

  constructor(
    private formBuilder: FormBuilder,
    private httpClient: HttpClient,
    private router: Router,
    private userService: UserService // Inject UserService
  ) {}

  ngOnInit(): void {
    this.claimForm = this.formBuilder.group({
      claimantName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', Validators.required],
      policyNumber: ['', Validators.required], // Add policyNumber field to the form
      description: ['', Validators.required]
    });

    // Fetch policy numbers based on user's email
    this.fetchPolicyNumbers();
  }

  fetchPolicyNumbers() {
    const userEmail = this.userService.getEmail(); // Get user's email from UserService
    // Make HTTP request to fetch policy numbers based on user's email
    this.httpClient.get<any[]>('http://localhost:8090/policyholders/' + userEmail + '/policies')
      .subscribe(response => {
        this.policyNumbers = response; // Assign fetched policy numbers to the array
      }, error => {
        console.error(error);
      });
  }
  onSubmit() {
    if (this.claimForm.valid) {
        this.httpClient.post<any>('http://localhost:8098/claims', this.claimForm.value)
            .subscribe(response => {
                console.log(response);
                // Display success message to the user
                alert('Claim submitted successfully!');
                // Reset the form
                this.claimForm.reset();
                this.router.navigate(['/homepage'], { skipLocationChange: true });
            }, error => {
                console.error(error);
                // Handle error response
                alert('An error occurred while submitting the claim. Please try again later.');
            });
    }
  }
}
