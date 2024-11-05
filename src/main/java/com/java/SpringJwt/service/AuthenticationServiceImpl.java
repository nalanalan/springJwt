package com.java.SpringJwt.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.java.SpringJwt.jwt.JwtProvider;
import com.java.SpringJwt.model.User;
import com.java.SpringJwt.security.UserPrincipal;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private final JwtProvider jwtProvider;
	private final AuthenticationManager authenticationManager;
	private final JwtRefreshTokenService jwtRefreshTokenService;
	
	@Override
	public User signInAndReturnJwt (User signInRequest) {
		
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));
		
		
		UserPrincipal userPrinciple =(UserPrincipal) authentication.getPrincipal();
		String jwt= jwtProvider.generateToken(userPrinciple);
		
		User signInUser = userPrinciple.getUser();
		signInUser.setId(signInUser.getId());
		signInUser.setAccessToken(jwt);
		signInUser.setRefreshToken(jwtRefreshTokenService.createRefreshToken(signInUser.getId()).getTokenId());
		return signInUser;
		
	}


	

}
