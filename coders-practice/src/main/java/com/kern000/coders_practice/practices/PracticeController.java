package com.kern000.coders_practice.practices;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController //class that response to req
@RequestMapping("/api/practices") // every api here have this base API
public class PracticeController {

    // Don't initialize new instance of repository every time a req comes into the controller;
    // so don't do public PracticeController(){
        // this.PracticeRepository = new PracticeRepository();
    // }

    // Dependency injection, we are going to ask Spring for it

    // @Autowired //not recommended - mock testing problematic - Autowire means Spring auto inject a dependency from the beans in its container // also create tight coupling betw classes and spring;
    private final PracticeRepository practiceRepository;

    public PracticeController(PracticeRepository practiceRepository){
        this.practiceRepository = practiceRepository;
    }

    @GetMapping()
    List<Practice> findAllPractices(){
        return practiceRepository.findAll();
    }

    @GetMapping("/{id}") //{id} is placeholder
    Practice findById(@PathVariable Integer id) {
        return practiceRepository.findById(id);
    }
    

    
}
