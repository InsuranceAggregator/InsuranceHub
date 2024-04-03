package com.rizwan.spring.data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rizwan.spring.data.entity.ResetPassword;
import com.rizwan.spring.data.service.ResetPasswordService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular frontend
public class ResetPasswordController {
	@Autowired
	private ResetPasswordService passwordService;
	
	@PutMapping("/reset-password")
	public ResponseEntity<Map<String, String>> resetPassword(@RequestBody ResetPassword resetPassword) {
	    String email = resetPassword.getEmail();
	    String newPassword = resetPassword.getPassword();
	    
	    if (passwordService.resetPassword(email, newPassword)) {
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Password reset successfully");
	        return ResponseEntity.ok(response);
	    } else {
	    	Map<String, String> response = new HashMap<>();
            response.put("error", "User not found with the given email");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
	}

	@GetMapping
	  public ResponseEntity<List<ResetPassword>> getAllUsers() {
	        var users = passwordService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
}
