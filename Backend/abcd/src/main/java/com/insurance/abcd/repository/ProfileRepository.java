package com.insurance.abcd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.abcd.model.UserProfile;

//import com.profile.profile.management.model.UserProfile;

@Repository
public interface ProfileRepository extends JpaRepository<UserProfile, Integer> {
	 UserProfile findByEmail(String email);
	
}


