package com.Userservice.Service;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.Userservice.DTO.LoginDTO;
import com.Userservice.DTO.RegistrationDTO;
 
@Service
public interface RegistrationService {
 
	List<RegistrationDTO> getAllRegistrations();
 
	List<RegistrationDTO> getAllUsers();

 
	boolean validateLogin(LoginDTO loginRequest);
 
	RegistrationDTO createUser(RegistrationDTO registrationDTO);

	boolean existsByEmail(String email);


}