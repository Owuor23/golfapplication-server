package com.golfapplication.golfapplicationserver.repositories;

import com.golfapplication.golfapplicationserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByUsername(String username);

}
