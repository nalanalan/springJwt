package com.java.SpringJwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.java.SpringJwt.jwt.JwtAutorizationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	
//	Logger logger = Logger.getLogger(SecurityConfig.class.getName());

	private final JwtAutorizationFilter jwtAuthorizationFilter;

	private final CustomUserDetailsService customUserDetailsService;



	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.cors(Customizer.withDefaults());
		http.csrf(AbstractHttpConfigurer::disable);	
		http.sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/authentication/**").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/product").permitAll()
				//.requestMatchers(HttpMethod.POST, "/api/product").hasRole(Role.ADMIN.name())  // admin kısıtlamasıyla create product a izin vermedi permitAll olarak değiştirdim
				
				.requestMatchers(HttpMethod.POST, "/api/product").permitAll()
				//.requestMatchers("/api/admin/**").hasRole(Role.ADMIN.name())
				.requestMatchers("/api/admin").permitAll() // admin kısıtlamasıyla edit product a izin vermedi permitAll olarak değiştirdim
				.requestMatchers("/api/purchase/**").permitAll()
				.requestMatchers("/api/user/**").permitAll()
				.anyRequest().authenticated());
		
		
		http.authenticationProvider(authenticationProvider());
		http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();

	}


	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customUserDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebMvcConfigurer corsConfigurers() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*") // İzin verilen frontend URL'ini															// buraya ekleyin
						.allowedMethods("*");
					//	.allowedHeaders("*")
					//	.allowCredentials(true);
			}
		};
	}
	
	

}

