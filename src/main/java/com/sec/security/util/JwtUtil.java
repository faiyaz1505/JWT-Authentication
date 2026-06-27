package com.sec.security.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final String SECRET="this_is_secret_key_for_jwt_authentication";
	private final SecretKey SECRET_KEY=Keys.hmacShaKeyFor(SECRET.getBytes());
	
	private final long EXPIRATION_TIME=1000*60;
	
	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SECRET_KEY, SignatureAlgorithm.HS256).compact();
	}

}
