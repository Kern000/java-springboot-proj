Goal: create a scalable, non-blocking MVC application using spring;

// Spring boot initializr
// group (group/indiv that created proj, often a reversed company domain name); artifact denotes base package name (what are we building);

f5 is shortkey to run springboot

// in CLI where relevant POM file is:
./mvnw spring-boot:run

// saw that port 8080 already in use, find PID of port which was 14644
netstat -ano | findstr :8080

// kill the port
// kill 14644

// use maven to run spring-boot again
// this is how we start server via CLI

// application context - container of all the classes in Java - can query it for a particular class

// Bean is just an instance of a class that the spring container (application context) is managing for me;

// put the component within the main package

// ConfigurableApplicationContext context = SpringApplication.run(CodersPracticeApplication.class, args);		

// WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage"); //casting

// System.out.println(welcomeMessage); // Need to use toString
// after retrieving a bean, need to cast to its desired type;

// getBean will look for the class but with first letter lowercase

// Based on documentation:
For a web application, you need only spring-boot-starter-web, since it depends transitively on the logging starter. If you use Maven, the following dependency adds logging for you:

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>

// log levels: info, warn, error, debug, trace;
// Logback framework is the logger;

It is possible to use H2 Database which is an in memory database, and it supports JDBC (Java Database connectivity API - defines how client connect and query DB - ORM based on Repository abstraction - Repository in Java is Data Access Layer - JBDC is synchronous) and R2DBC (For reactive programming - Asynchronous for non-blocking)

After renaming the h2 DB name: loopback address w port number service URI
http://127.0.0.1:8085/h2-console/login.jsp?jsessionid=bc6c03bbd35880bc154082c2f768dafc

url = jdbc:h2:mem:coders-practice

h2 is not for persistent data usage

Compose also supports docker-compose.yaml and docker-compose.yml for backwards compatibility of earlier versions

Spring Data is collection of tools and framework tt tries to save on CRUD methods for data access. JPA - Java Persistence API is the standard approach to ORM in Java; Hibernate ORM implements Spring Data JPA; 

Spring Data JDBC focus on simplifying data access layer using plain JDBC rather than JPA

Rest Client can be implemented in the spring framework - it is used to consume API endpoints/webservices provided by another application or service. 
=> under the web spring dependency;

