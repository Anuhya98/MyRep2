package com.cts.training.userservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
