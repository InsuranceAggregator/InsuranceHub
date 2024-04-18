package com.Userservice.Controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.Userservice.DTO.LoginDTO;
import com.Userservice.DTO.RegistrationDTO;
import com.Userservice.Service.RegistrationService;
 
@RestController
@RequestMapping("/api/v")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
 
    private final RegistrationService registrationService;
 
    @Autowired
    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> createUser( @RequestBody RegistrationDTO registrationDTO){
       try {
          if (registrationService.existsByEmail( registrationDTO.getEmail())) {
             return new ResponseEntity<>("Email ID already exists", HttpStatus.CONFLICT);
          }
          RegistrationDTO createdRegistrationDTO = registrationService.createUser(registrationDTO);
          return new ResponseEntity<>("User Registration Successful", HttpStatus.CREATED);
       }catch (Exception e) {
          return new ResponseEntity<>("User Registration is failed" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }}
 
//    @PostMapping("/register")
//    public ResponseEntity<String> createUser(@RequestBody RegistrationDTO registrationDTO) {
//        try {
//            registrationService.createUser(registrationDTO);
//            return new ResponseEntity<>("User Registration Successful", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("User Registration failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    //}
 
    @GetMapping("/registereddetails")
    public ResponseEntity<List<RegistrationDTO>> getAllUsers() {
        List<RegistrationDTO> registrationDTO = registrationService.getAllUsers();
        return new ResponseEntity<>(registrationDTO, HttpStatus.OK);
    }
 
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginRequest) {
        Map<String, String> response = new HashMap<>();
        if (loginRequest == null || loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            response.put("message", "Email or Password can't be Empty");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        if (registrationService.validateLogin(loginRequest)) {
            response.put("message", "Login Successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Invalid Credentials");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            
        }
    }
 
}
