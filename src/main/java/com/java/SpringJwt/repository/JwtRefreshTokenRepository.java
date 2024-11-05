package com.java.SpringJwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SpringJwt.model.JwtRefreshToken;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String> {

}
