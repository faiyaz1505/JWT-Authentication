package com.sec.security.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sec.security.entity.AuthRequest;
import com.sec.security.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final JwtUtil jwtUtil;
	
	private final AuthenticationManager authenticationManager;
	public AuthController(AuthenticationManager authenticationManager,JwtUtil jwtUtil) {
		this.authenticationManager=authenticationManager;
		this.jwtUtil=jwtUtil;
	}
	
	
	
	@GetMapping("/login")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
					);
			
			return jwtUtil.generateToken(authRequest.getUsername());
		} catch (Exception e) {
			throw e;
		}
		
		
		
		
	}

}
