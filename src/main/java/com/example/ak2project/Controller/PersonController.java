package com.example.ak2project.Controller;


import com.example.ak2project.Model.Person;
import com.example.ak2project.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepo personRepo;

    @GetMapping
    @ResponseBody
    public String writeSomething() {
        return "HelloWorld";
    }

    @GetMapping("/person")
    @ResponseBody
    public List<Person> getPeople() {
        return personRepo.getPeople();
    }

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        personRepo.addPerson(person);
    }
}

