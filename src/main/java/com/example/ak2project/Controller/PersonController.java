package com.example.ak2project.Controller;


import com.example.ak2project.Model.Person;
import com.example.ak2project.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping
    @ResponseBody
    public String writeSomething() {
        return "HelloWorld";
    }

    @GetMapping("/person")
    @ResponseBody
    public List<Person> getPeople() {
        return personRepository.getPeople();
    }

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        personRepository.addPerson(person);
    }
}

