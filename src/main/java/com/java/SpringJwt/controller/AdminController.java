package com.java.SpringJwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringJwt.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/admin") // pre-path
@RequiredArgsConstructor
public class AdminController {
	
	private final UserService userService;
	
	@GetMapping("all")
	public ResponseEntity<?>findAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}

}
