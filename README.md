For the Spring Boot Rest API deployed on AWS EC2 and using a AWS RDS, please visit https://github.com/Kern000/spring-boot-docker-jdk-17

This is the Spring Boot Rest API using JDK 22 as an experiment for H2 in-memory Database and PostgreSQL docker image.

<h2>Routes:</h2>
<h4> /api/practices </h4>
<p> The HTTP Verb required is GET.</p>

<h4> /api/practices/{id} </h4>
<p> Example: /api/practices/1 </p>
<p> The HTTP Verb required is GET. </p>

<h4> /api/practices/create </h4>
<p> Used with YARC or an API endpoint consumption. The HTTP Verb required is POST. </p> 

<h4> /api/practices/update/{id} </h4>
<p> Example: /api/practices/update/1 </p>
<p> Used with YARC or an API endpoint consumption. The HTTP Verb required is PUT. </p>

<h4> /api/practices/delete/{id} </h4>
<p> Example: /api/practices/delete/1 </p>
<p> Used with YARC or an API endpoint consumption. The HTTP Verb required is DELETE.</p>

<h4> Other Features: </h4>
<ol>
<li> INFO level logging on root </li>
<li> TRACE level logging on "practice" folder level </li>
<li> gzip server compression on various HTTP data types </li>
<li> SQL initial piping, SQL seeding </li>
<li> SQL Parameterization on Data Access Layer </li>
</ol>
