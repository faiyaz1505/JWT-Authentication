package com.sec.security.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sec.security.entity.User;
import com.sec.security.repository.UserRepo;

@Component
public class AdminInitializer {
	
	
	@Bean
	public CommandLineRunner createAdminCreds(UserRepo repo,PasswordEncoder encoder) {
		
		return args->{
			if(repo.getByUsername("admin").isEmpty()) {
				User user=new User();
				user.setUsername("admin");
				user.setPassword(encoder.encode("admin123"));
				user.setRole("ROLE_ADMIN");
				repo.save(user);
			}
		};
		
	}

}
