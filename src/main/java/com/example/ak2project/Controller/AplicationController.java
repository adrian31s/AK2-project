package com.example.ak2project.Controller;

import com.example.ak2project.Model.Person;
import com.example.ak2project.Repository.PersonRepository;
import org.apache.juli.logging.Log;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;


@RestController
public class AplicationController {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        runScript();
        return "test";
    }

    @Transactional
    @GetMapping("/runscript")
    public String runScript()  {

        try {

            Resource resource = resourceLoader.getResource("classpath:bd.txt");
            File file = resource.getFile();

            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()) {
                return  scanner.nextLine();
            }
            scanner.close();

        } catch (IOException e) {
            return "file not found";
        }

        return "test";
    }
}

