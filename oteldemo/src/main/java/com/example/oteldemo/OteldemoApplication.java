package com.example.oteldemo;

import com.example.oteldemo.user.MyUser;
import com.example.oteldemo.user.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OteldemoApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initialData() {
		userRepository.save(new MyUser("Name 01"));
		userRepository.save(new MyUser("Name 02"));
		userRepository.save(new MyUser("Name 03"));
		userRepository.save(new MyUser("Name 04"));
		userRepository.save(new MyUser("Name 05"));
	}

	public static void main(String[] args) {
		SpringApplication.run(OteldemoApplication.class, args);
	}

}
