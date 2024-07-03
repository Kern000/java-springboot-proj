package com.kern000.coders_practice.practices;

import org.springframework.data.repository.ListCrudRepository;

public interface SpringDataPracticeRepo extends ListCrudRepository<Practice, Integer>{
    // revision: interface specifies set of methods a class must implement if they implement the interface, unless use "Abstract" to declare the class
    // argument of ListCrudRepo - takes argument of the Type: Practice and the Id type of a Practice is an Integer

}
