// UserRepo.java
 
package com.Userservice.Repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Userservice.model.User;
 
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
   // User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
	boolean existsByEmail(String email);
}