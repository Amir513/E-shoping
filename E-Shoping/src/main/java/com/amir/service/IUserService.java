package com.amir.service;

import com.amir.model.User;

public interface IUserService {
	public void saveUser(User user);
	public User findUserByEmail(String email);
}

