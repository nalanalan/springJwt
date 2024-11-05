package com.java.SpringJwt.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringJwt.model.Role;
import com.java.SpringJwt.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")//pre-path
@RequiredArgsConstructor
public class UserController {
	
	
	private final UserService userService;
		
		
	@PostMapping("/change/{role}")	
	public ResponseEntity<?> changeRole(@PathVariable("role") Role role, @RequestParam("username") String username){	
	userService.changeRole(role, username);
		return ResponseEntity.ok(true);
	}



}





//@PutMapping("/change/{role}") //api/user/chance/{role}   // because of security context config stateless not to get user info
//public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrinciple, @PathVariable Role role) {
//	userService.changeRole(role, userPrinciple.getUser().getUsername());
//	return ResponseEntity.ok(true);
//}