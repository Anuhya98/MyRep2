package com.cts.training.userservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email);

	public Optional<User> findByUsernameAndPassword(String username, String password);
}
