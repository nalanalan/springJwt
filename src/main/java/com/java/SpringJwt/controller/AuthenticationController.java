package com.java.SpringJwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringJwt.model.User;
import com.java.SpringJwt.service.AuthenticationService;
import com.java.SpringJwt.service.JwtRefreshTokenService;
import com.java.SpringJwt.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/authentication/") // from secConfig
@RequiredArgsConstructor
public class AuthenticationController {

//	Logger logger = Logger.getLogger(AuthenticationController.class.getName());

	private final AuthenticationService authenticationService;
	private final UserService userService;
	private final JwtRefreshTokenService jwtRefreshTokenService;

	@PostMapping("sign-up") // api/authentication/sign-up
	public ResponseEntity<?> signUp(@RequestBody User user) {

		if (userService.findByUsername(user.getUsername()).isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

	}

	@PostMapping("sign-in") // api/authentication/sign-in
	public ResponseEntity<?> signIn(@RequestBody User user) {

		return new ResponseEntity<>(authenticationService.signInAndReturnJwt(user), HttpStatus.OK);
	}

	@PostMapping("refresh-token") // api/authentication/refresh-token?token=
	public ResponseEntity<?> refreshToken(@RequestParam String token) {
		return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
	}

}
