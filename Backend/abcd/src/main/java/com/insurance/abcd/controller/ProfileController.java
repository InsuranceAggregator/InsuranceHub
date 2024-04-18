package com.insurance.abcd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.abcd.model.UserProfile;
import com.insurance.abcd.service.ProfileService;

@Controller
@RestController
@RequestMapping("/profiles")
@CrossOrigin("*")
public class ProfileController {

	    private final ProfileService profileService;

	    @Autowired
	    public ProfileController(ProfileService profileService) {
	        this.profileService = profileService;
	    }

	    @GetMapping("/{email}")
	    public ResponseEntity<UserProfile> getUserProfileByEmail(@PathVariable String email) {
	        UserProfile userProfile = profileService.getUserProfileByEmail(email);
	        if (userProfile != null) {
	            return ResponseEntity.ok(userProfile);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
	        UserProfile createdUserProfile = profileService.createUserProfile(userProfile);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserProfile);
	    }

	    @PutMapping("/{email}")
	    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable String email, @RequestBody UserProfile userProfile) {
	        UserProfile updatedUserProfile = profileService.updateUserProfile(email, userProfile);
	        if (updatedUserProfile != null) {
	            return ResponseEntity.ok(updatedUserProfile);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	   
	}