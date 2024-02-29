package com.sap.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.service.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	public UserServiceImpl(@Autowired UserRepository repository) {
		super(User.class, repository);
	}

	@Override
	public User getByEmail(String email) {
		User user = repository.getByEmail(email);
		return user;
	}

}
