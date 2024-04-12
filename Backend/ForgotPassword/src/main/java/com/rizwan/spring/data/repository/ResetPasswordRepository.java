package com.rizwan.spring.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rizwan.spring.data.entity.ResetPassword;

public interface ResetPasswordRepository extends JpaRepository<ResetPassword, Integer> {
	Optional<ResetPassword>findByEmail(String email);
}
