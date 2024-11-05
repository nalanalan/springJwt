package com.java.SpringJwt.jwt;

import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;
import com.java.SpringJwt.security.UserPrincipal;


public interface JwtProvider {

	String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
	
	

}
