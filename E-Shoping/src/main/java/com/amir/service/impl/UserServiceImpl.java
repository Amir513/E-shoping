/**
 * 
 */
package com.amir.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.amir.model.User;
import com.amir.repo.UserRepository;
import com.amir.service.IUserService;

/**
 * @author Amir Khan
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByUserEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
		userRepository.save(user);
	}

}