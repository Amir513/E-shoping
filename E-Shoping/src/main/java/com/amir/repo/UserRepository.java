package com.amir.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {
	 User findByUserEmail(String email);

}
