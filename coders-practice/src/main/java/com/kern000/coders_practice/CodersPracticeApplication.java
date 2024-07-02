package com.kern000.coders_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;

// import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger; //logger
import org.slf4j.LoggerFactory; //interface, not the actual logger

import org.springframework.context.annotation.Bean;

import com.kern000.coders_practice.practices.LanguageType;
import com.kern000.coders_practice.practices.Practice;

@SpringBootApplication
public class CodersPracticeApplication {

	private static final Logger log = LoggerFactory.getLogger(CodersPracticeApplication.class);

	public static void main(String[] args) {
			
			SpringApplication.run(CodersPracticeApplication.class, args);		

			// ConfigurableApplicationContext context = SpringApplication.run(CodersPracticeApplication.class, args);		
			// WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage"); //casting
			// System.out.println(welcomeMessage); // Need to use toString
			// after retrieving a bean, need to cast to its desired type;
			// log.info("Application started successfully");
			// log.trace("Main method accessed");			
	}

	@Bean  //declares method tt returns object to be managed by Spring (IOC) inversion of control container //declare the output to be managed as beans by Spring IoC Container // dependency injection, dependencies of bean auto resolved and injected by Spring IoC Container, and dun need instantiate and config these components
	CommandLineRunner runner(){ //command line runner indicate bean shld run when within Spring Application // params are at the runner ()
		return (args) -> {
			ArrayList <String> topicsCovered = new ArrayList<String>();
			topicsCovered.add("Java Spring Boot setup");
			topicsCovered.add("Application configuration for Spring Boot");
			topicsCovered.add("Logging and levels");
			LanguageType languageCovered = LanguageType.Java;	
			Practice practice = new Practice(1, "First Practice", LocalDateTime.now(), LocalDateTime.now().plusHours(2),topicsCovered, languageCovered);
			log.info("Practice: " + practice);
		};
	} //run when application start

}
