package com.java.SpringJwt.service;

import com.java.SpringJwt.model.JwtRefreshToken;
import com.java.SpringJwt.model.User;

public interface JwtRefreshTokenService  {

	JwtRefreshToken createRefreshToken(Long userId);

    User generateAccessTokenFromRefreshToken(String refreshTokenId);

}
