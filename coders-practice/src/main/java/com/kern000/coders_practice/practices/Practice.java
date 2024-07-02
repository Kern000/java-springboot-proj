package com.kern000.coders_practice.practices;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.time.LocalDateTime;
import java.time.Duration;

public class Practice {

    //fields tt this class needs to know about
    private Integer id;
    private String title;
    private LocalDateTime timeStarted;
    private LocalDateTime timeEnded;
    private ArrayList<String> topicsCovered = new ArrayList<String>();
    // private Location location;

    public Practice(Integer id, String title, LocalDateTime timeStarted, LocalDateTime timeEnded, ArrayList<String> topicsCovered){
        this.id = id;
        this.title = title;
        this.timeStarted = timeStarted;
        this.timeEnded = timeEnded;
        this.topicsCovered = topicsCovered;
        if(timeStarted.isAfter(timeEnded)){
            throw new IllegalArgumentException("Time started cannot be after time ended.");
        }
    }

    //getters
    public Duration geDuration(){
        return Duration.between(timeStarted, timeEnded);
    }

    public Integer getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public LocalDateTime getStartTime(){
        return timeStarted;
    }

    public LocalDateTime getEndTime(){
        return timeEnded;
    }

    public ArrayList<String> getTopicsCovered(){
        return topicsCovered;
    }

    public Duration getDuration(){
        return Duration.between(timeStarted, timeEnded);
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setStartTime(LocalDateTime timeStarted){
        this.timeStarted = timeStarted;
    }

    public void setEndTime(LocalDateTime timeEnded){
        this.timeEnded = timeEnded;
    }

    public void getTopicsCovered(ArrayList<String> topicsCovered){
        this.topicsCovered = topicsCovered;
    }
    
    //objects that are equal (or the same object) must consistently return the same hash code;
    //diff objects do not need return diff hash codes, though distinct hash codes improves performance of hash tables;

    @Override
    public int hashCode(){
        return Objects.hash(id,title,timeStarted,timeEnded,topicsCovered);
    }

}