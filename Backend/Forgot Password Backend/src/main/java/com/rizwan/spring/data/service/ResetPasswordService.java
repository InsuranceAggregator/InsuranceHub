package com.rizwan.spring.data.service;

import java.util.List;
import java.util.Optional;

import com.rizwan.spring.data.entity.ResetPassword;

public interface ResetPasswordService {
	
	List<ResetPassword> getAllUsers();
	boolean resetPassword(String email, String newPassword);
}
