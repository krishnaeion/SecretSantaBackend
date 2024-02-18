package com.rishi.SecretSantaBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
	
@Bean
public UserDetailsService userDetailsService() {
	UserDetails user=User 
			.withUsername("me")
			.password(passwordEncoder().encode("hi"))
			.roles("admin")
			.build();
	
	UserDetails user2=User 
			.withUsername("new")
			.password(passwordEncoder().encode("new"))
			.roles("addUser")
			.build();
	return new InMemoryUserDetailsManager(user,user2);
}
	
@Bean
public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception  {
	httpSecurity.csrf().disable()
	.authorizeHttpRequests()
	.requestMatchers("/api/users/allUsers")
	.hasRole("admin")
	.requestMatchers("/api/users/addUser")
	.hasRole("addUser")
	.anyRequest()
	.authenticated().
	and()
	.formLogin();
	
	return httpSecurity.build();
}
}
