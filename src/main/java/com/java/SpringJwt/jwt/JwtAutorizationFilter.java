package com.java.SpringJwt.jwt;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtAutorizationFilter extends OncePerRequestFilter {
	
	
	
	private final JwtProvider jwtProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Authentication authentication=jwtProvider.getAuthentication(request);
		
		
		if (authentication!=null && jwtProvider.isTokenValid(request)) {
			SecurityContextHolder.getContext().setAuthentication(authentication);

		}
		
		
		filterChain.doFilter(request, response);
	}
	
	

}
