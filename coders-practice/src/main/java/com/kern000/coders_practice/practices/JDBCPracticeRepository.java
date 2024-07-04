package com.kern000.coders_practice.practices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.util.Assert;

import org.springframework.stereotype.Repository;
// import jakarta.annotation.PostConstruct;

@Repository //central hub for managing all data access logic //This makes this a bean and joins the Spring IoC container
public class JDBCPracticeRepository {

    private static final Logger log = LoggerFactory.getLogger(JDBCPracticeRepository.class);
    private final JdbcClient jdbcClient;

    public JDBCPracticeRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Practice> findAll(){
        return jdbcClient.sql("SELECT * FROM Practice")
                            .query(Practice.class) //may the result to a Practice object
                            .list(); //return list of things
    }

    public Optional<Practice> findById(Integer id){
        return jdbcClient.sql("SELECT * FROM Practice WHERE id = :id")
                            .param("id", id)
                            .query(Practice.class)
                            .optional();
    }

    public void createOne(Practice practice){
        // is creating variable without specifying type
        var updated = jdbcClient.sql("INSERT INTO Practice(id,title,time_started,time_ended,topics_covered,coding_language) values(?,?,?,?,?,?)")
                        .params(List.of(    practice.getId(),
                                            practice.getTitle(),
                                            practice.getStartTime(),
                                            practice.getEndTime(),
                                            practice.getTopicsCovered().toString(),
                                            practice.getLanguageType().toString()
                                        )
                                )
                        .update(); //returns how many rows affected so check if it is 1
        Assert.state(updated == 1, "Failed to create new practice " + practice.getTitle());
    }

    public void updateOneById(Integer id, Practice practice){
        var updated = jdbcClient.sql("update Practice set title = ?, time_started = ?, time_ended = ?, topics_covered = ?, coding_language = ? WHERE id =?")
                                    .params(List.of(    practice.getTitle(), 
                                                        practice.getStartTime(), 
                                                        practice.getEndTime(), 
                                                        practice.getTopicsCovered().toString(), 
                                                        practice.getLanguageType().toString(),
                                                        id))
                                    .update(); // jbdc methods
        Assert.state(updated == 1, "Failed to update practice " + practice.getTitle());
    }

    public void delete(Integer id){
        var updated = jdbcClient.sql("delete from Practice where id = :id")
                                    .param("id", id)
                                    .update();
        Assert.state(updated == 1, "Failed to delete practice id " + id);
    }

    // ========================================================================= //
    // From Here Onwards was prev version using in memory non-DB CRU

    // private List<Practice> practices = new ArrayList<>();
    // use more generic implement umbrella of List so if change to other types in umbrella, dont need change so much code

    // List<Practice> findAll(){
    //     return practices;
    // }

    // Practice findById(Integer id){
    //     return practices.stream()   //super combo :) love this method
    //                     .filter(practice -> practice.getId() == id) //using the getter method
    //                     .findFirst()
    //                     .get(); //returns the object returned by findFirst, otherwise throws exception
    // }

    // Optional<Practice> findById(Integer id){
    //     return practices.stream()   //super combo :) love this method
    //                     .filter(practice -> practice.getId() == id) //using the getter method
    //                     .findFirst();                        // .get(); //returns the object returned by findFirst, otherwise throws exception
    // }
    // // using optional to prevent null exception being thrown
    // // returns 'optional' object that may or may not contain any value;

    // void createOne(Practice practice){
    //     practices.add(practice);
    // }

    // void updateOneById(Integer id, Practice replacementPractice){
    //     Optional<Practice> existingPractice = findById(id);
    //     if(existingPractice.isPresent()){
    //         practices.set(practices.indexOf(existingPractice.get()),replacementPractice);
    //     }
    // }

    // void delete(Integer id){
    //     practices.removeIf(practice -> practice.getId().equals(id));
    // }

    //Use data in memory first, later on going on to use DB
    // @PostConstruct
    // private void init(){

    //     ArrayList <String> topicsCovered1 = new ArrayList<String>();
    //     topicsCovered1.add("Java Spring Boot setup");
    //     topicsCovered1.add("Application configuration for Spring Boot");
    //     topicsCovered1.add("Logging and levels");
    //     LanguageType languageCovered1 = LanguageType.Java;	

    //     ArrayList <String> topicsCovered2 = new ArrayList<String>();
    //     topicsCovered2.add("Bean, what a bean is"); //beans are objects managed in 
    //     topicsCovered2.add("RestController annotation");
    //     topicsCovered2.add("post construct - execute after dependency Injection by Spring IoC");
    //     LanguageType languageCovered2 = LanguageType.Java;

    //     practices.add(new Practice(1, "First Practice", LocalDateTime.now(), LocalDateTime.now().plusHours(2),topicsCovered1, languageCovered1));
    //     practices.add(new Practice(2, "Second Practice", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4),topicsCovered2, languageCovered2));
    // }
}

