FROM maven:3.9.6 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Base image for new container
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/coders-practice-0.0.1-SNAPSHOT.jar ./coders-practice-aws.jar
EXPOSE 8085
CMD ["java", "-jar", "coders-practice-aws,jar"]
#to run the -jar file (executable);
