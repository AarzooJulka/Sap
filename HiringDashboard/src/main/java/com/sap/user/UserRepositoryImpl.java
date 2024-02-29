package com.sap.user;

import org.springframework.stereotype.Repository;

import com.sap.repository.BaseRepositoryImpl;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class);
	}
}