package com.kern000.coders_practice.practices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository //central hub for managing all data access logic //This makes this a bean and joins the Spring IoC container
public class PracticeRepository {

    private List<Practice> practices = new ArrayList<>();
    // use more generic implement umbrella of List so if change to other types in umbrella, dont need change so much code

    List<Practice> findAll(){
        return practices;
    }

    Practice findById(Integer id){
        return practices.stream()   //super combo :) love this method
                        .filter(practice -> practice.getId() == id) //using the getter method
                        .findFirst()
                        .get();
    }

    //Use data in memory first, later on going on to use DB
    @PostConstruct
    private void init(){

        ArrayList <String> topicsCovered1 = new ArrayList<String>();
        topicsCovered1.add("Java Spring Boot setup");
        topicsCovered1.add("Application configuration for Spring Boot");
        topicsCovered1.add("Logging and levels");
        LanguageType languageCovered1 = LanguageType.Java;	

        ArrayList <String> topicsCovered2 = new ArrayList<String>();
        topicsCovered2.add("Bean, what a bean is"); //beans are objects managed in 
        topicsCovered2.add("RestController annotation");
        topicsCovered2.add("post construct - execute after dependency Injection by Spring IoC");
        LanguageType languageCovered2 = LanguageType.Java;

        practices.add(new Practice(1, "First Practice", LocalDateTime.now(), LocalDateTime.now().plusHours(2),topicsCovered1, languageCovered1));
        practices.add(new Practice(2, "Second Practice", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4),topicsCovered2, languageCovered2));
    }
}
