package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public AuthenticationResponse register (User request) {
		
		User user = new User();
		
		user.setFristname(request.getFristname());
		user.setLastname(request.getLastname());
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		
		userRepository.save(user);
		
		String token = jwtService.generateToken(user);
		
		return new AuthenticationResponse(token);
	}
	
	public AuthenticationResponse authencticate (User request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(), 
						request.getPassword())
				);
		User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new IllegalArgumentException("User not found with : " + request.getUsername()));
		
		String token = jwtService.generateToken(user);
		
		return new AuthenticationResponse(token);
	}
}
