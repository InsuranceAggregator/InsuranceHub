package com.rizwan.spring.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rizwan.spring.data.entity.ResetPassword;
import com.rizwan.spring.data.repository.ResetPasswordRepository;

import jakarta.transaction.Transactional;
@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {
	@Autowired
	private ResetPasswordRepository repository;

	@Override
	public List<ResetPassword> getAllUsers() {
		return repository.findAll();
	}

	@Transactional
    public boolean resetPassword(String email, String newPassword) {
        Optional<ResetPassword> userOptional = repository.findByEmail(email);
        if (userOptional.isPresent()) {
            ResetPassword resetPassword = userOptional.get();
            resetPassword.setPassword(newPassword);
            repository.save(resetPassword);
            return true;
        }
        return false; // User not found with the given email
    }

}
