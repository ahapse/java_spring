package com.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.web.dao.UserRepository;
import com.springboot.web.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
//		UserRepository userRepository = context.getBean(UserRepository.class);
		
		@Autowired
		UserRepository userRepository;
		
		User user = new User();
		
		user.setName("Avdhoot");
		user.setCity("Pune");
		user.setStatus("Fullstack Intern");
		
		User user2 = userRepository.save(user);
		System.out.println(user2);
		
		
	}

}
