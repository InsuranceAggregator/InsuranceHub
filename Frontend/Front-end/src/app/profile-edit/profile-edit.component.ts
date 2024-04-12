
import { Component, OnInit } from '@angular/core';
import { ProfileEditService } from '../profile-edit.service';
import { UserService } from '../user.service';
 
@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {
  profile: any = {};
  
 
 
 
  constructor(private profileService: ProfileEditService, private userService: UserService) { }
 
  ngOnInit() {

    
    this.loadUserProfile();
  }
 
  loadUserProfile() {
    // Fetch the user profile based on the specified email
    const userEmail = this.userService.getEmail(); 
    if (userEmail) {
      this.profileService.getUserProfileByEmail(userEmail)
        .subscribe(data => {
          this.profile = data;
        }, error => {
          console.error('Error loading user profile:', error);
        });
    } else {
      console.error('Email not available');
    }
  }
 
  onSubmit() {
    // Update user profile data based on the email retrieved from UserService
    const userEmail = this.userService.getEmail(); // Get email from user service
    if (userEmail) {
      this.profileService.updateUserProfile(userEmail, this.profile)
        .subscribe(updatedProfile => {
          console.log('Profile data updated:', updatedProfile);
          alert('profile updated successfully');
          // Optionally, perform any additional actions after successful update
        }, error => {
          console.error('Error updating profile:', error);
          // Optionally, handle error scenarios
        });
    } else {
      console.error('Email not available');
    }
  }
}