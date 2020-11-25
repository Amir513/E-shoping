/**
 * 
 */
package com.amir.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amir.model.Role;
import com.amir.model.User;
import com.amir.repo.UserRepository;

/**
 * @author Amir Khan
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUserEmail(username);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
	        }

	        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getPassword(), grantedAuthorities);
	    }
	}