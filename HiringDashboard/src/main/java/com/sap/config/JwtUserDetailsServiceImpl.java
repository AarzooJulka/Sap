package com.sap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sap.user.User;
import com.sap.user.UserService;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

	@Autowired
	UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = service.getByEmail(username);

		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
