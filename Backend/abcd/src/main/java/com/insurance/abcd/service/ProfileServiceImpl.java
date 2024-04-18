package com.insurance.abcd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.abcd.model.UserProfile;
import com.insurance.abcd.repository.ProfileRepository;

//import com.profile.profile.management.model.UserProfile;
//import com.profile.profile.management.repository.ProfileRepository;
@Service
public class ProfileServiceImpl implements ProfileService{

	private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public UserProfile getUserProfileByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
        return profileRepository.save(userProfile);
    }

    public UserProfile updateUserProfile(String email, UserProfile userProfile) {
        UserProfile existingUserProfile = profileRepository.findByEmail(email);
        if (existingUserProfile != null) {
            userProfile.setEmail(email);
            return profileRepository.save(userProfile);
        }
        return null;
    }
}
