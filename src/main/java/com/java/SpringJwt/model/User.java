package com.java.SpringJwt.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="username", unique = true, nullable = false, length = 100)
	private String username;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="create_time", nullable = false)
	private LocalDateTime createTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable = false)
	private Role role;
	
	@Transient
	private String accessToken;
	
	@Transient
	private String refreshToken;
	
	
//	 @Override
//	    public Collection<? extends GrantedAuthority> getAuthorities() {
//	        return List.of();
//	    }
//
//	    public String getPassword() {
//	        return password;
//	    }
//
//	    @Override
//	    public String getUsername() {
//	        return username;
//	    }
//
//	    @Override
//	    public boolean isAccountNonExpired() {
//	        return true;
//	    }
//
//	    @Override
//	    public boolean isAccountNonLocked() {
//	        return true;
//	    }
//
//	    @Override
//	    public boolean isCredentialsNonExpired() {
//	        return true;
//	    }
//
//	    @Override
//	    public boolean isEnabled() {
//	        return true;
//	    }
//	    

}
