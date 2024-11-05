package com.java.SpringJwt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.java.SpringJwt.model.Role;
import com.java.SpringJwt.model.User;
import com.java.SpringJwt.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setCreateTime(LocalDateTime.now());
				
		return userRepository.save(user);		
	}
	
	@Override
	public Optional<User> findByUsername(String username){
		return userRepository.findByUsername(username);	
	}
	
	@Override
	@Transactional // is required when executing on update/delete query
	public void changeRole(Role newRole, String username) {
		userRepository.updateUserRole(username, newRole);
		
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		 return userRepository.findAll();
	} 

}
