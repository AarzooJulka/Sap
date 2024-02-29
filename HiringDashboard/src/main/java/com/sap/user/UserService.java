package com.sap.user;

import com.sap.service.BaseService;

public interface UserService extends BaseService<User> {

	User getByEmail(String email);

}
