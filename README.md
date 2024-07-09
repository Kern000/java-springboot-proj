For the Spring Boot Rest API deployed on AWS EC2 and using a AWS RDS, please visit https://github.com/Kern000/spring-boot-docker-jdk-17

This is the Spring Boot Rest API using JDK 22 as an experiment for H2 in memory Database and PostgreSQL docker image.

Routes:
/api/practices
The HTTP Verb required is GET.

/api/practices/{id}
Example: /api/practices/1
The HTTP Verb required is GET.

/api/practices/create
Used with YARC or an API endpoint consumption. The HTTP Verb required is POST.

/api/practices/update/{id}
Example: /api/practices/update/1
Used with YARC or an API endpoint consumption. The HTTP Verb required is PUT.

/api/practices/update/{id}
Example: /api/practices/update/1
Used with YARC or an API endpoint consumption. The HTTP Verb required is PUT.

/api/practices/delete/{id}
Example: /api/practices/delete/1
Used with YARC or an API endpoint consumption. The HTTP Verb required is DELETE.

Other Features:
1. INFO level logging on root
2. TRACE level logging on "practice" folder level
3. gzip server compression on various HTTP data types
4. SQL initial piping, SQL seeding
5. SQL Parameterization on Data Access Layer
