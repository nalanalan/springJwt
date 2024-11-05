package com.java.SpringJwt.service;

import com.java.SpringJwt.model.User;

public interface AuthenticationService {
	
	User signInAndReturnJwt(User signInRequest);

}
