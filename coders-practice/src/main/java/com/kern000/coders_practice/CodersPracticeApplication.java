package com.kern000.coders_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger; //logger
import org.slf4j.LoggerFactory; //interface, not the actual logger

@SpringBootApplication
public class CodersPracticeApplication {

	private static final Logger log = LoggerFactory.getLogger(CodersPracticeApplication.class);

	public static void main(String[] args) {
			
			SpringApplication.run(CodersPracticeApplication.class, args);		

			// ConfigurableApplicationContext context = SpringApplication.run(CodersPracticeApplication.class, args);		
			// WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage"); //casting
			// System.out.println(welcomeMessage); // Need to use toString
			// after retrieving a bean, need to cast to its desired type;
			log.info("Application started successfully");
			log.trace("Main method accessed");

			

	}

	

}
