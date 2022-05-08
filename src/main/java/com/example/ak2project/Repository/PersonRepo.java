package com.example.ak2project.Repository;


import com.example.ak2project.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRepo {
    @Autowired
    PersonRepository personRepository;

    public void addPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getPeople(){
        return personRepository.findAll();
    }
}
