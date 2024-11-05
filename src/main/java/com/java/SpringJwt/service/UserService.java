package com.java.SpringJwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.SpringJwt.model.Role;
import com.java.SpringJwt.model.User;

@Service


public interface UserService {

	User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);

    List<User> findAllUsers();



}
