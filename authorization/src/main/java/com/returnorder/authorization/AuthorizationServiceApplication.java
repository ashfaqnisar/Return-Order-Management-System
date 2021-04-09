package com.returnorder.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.returnorder.authorization.entity.User;
import com.returnorder.authorization.repository.UserRepository;

@SpringBootApplication
public class AuthorizationServiceApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AuthorizationServiceApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("batman", passwordEncoder.encode("bruce"), "ROLE_USER"));
		userRepository.save(new User("superman", passwordEncoder.encode("clark"), "ROLE_USER"));
		userRepository.save(new User("ironman", passwordEncoder.encode("stark"), "ROLE_USER"));
		userRepository.save(new User("spiderman", passwordEncoder.encode("peter"), "ROLE_USER"));
	}
}
