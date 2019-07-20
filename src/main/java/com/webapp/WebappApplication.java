package com.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.webapp.domain.User;
import com.webapp.enums.ProfileEnum;
import com.webapp.repositories.UserRepository;

@SpringBootApplication
public class WebappApplication {

	 
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUser(userRepository,passwordEncoder);
		};
	}
	
	private void initUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@email.com");
		admin.setPassword(passwordEncoder.encode("1234"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		User userExist = userRepository.findByEmail("admin@email.com");
		if(userExist == null) {
			userRepository.save(admin);
		}
	}
	
}
