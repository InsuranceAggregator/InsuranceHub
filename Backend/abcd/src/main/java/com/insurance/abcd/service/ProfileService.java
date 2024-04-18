package com.insurance.abcd.service;

import com.insurance.abcd.model.UserProfile;

//import com.profile.profile.management.model.UserProfile;

public interface ProfileService {
	UserProfile getUserProfileByEmail(String email);
	UserProfile createUserProfile(UserProfile userProfile);
	UserProfile updateUserProfile(String email, UserProfile userProfile); 

}
