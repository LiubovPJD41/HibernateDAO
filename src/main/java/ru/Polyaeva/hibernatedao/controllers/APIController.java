package ru.Polyaeva.hibernatedao.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.Polyaeva.hibernatedao.entities.Person;
import ru.Polyaeva.hibernatedao.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class APIController {
    private final PersonRepository personRepository;

    @Autowired
    public APIController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getAllPersonsByCity(@RequestParam String city) {
        return this.personRepository.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getAllPersonsByAge(@RequestParam int age) {
        return this.personRepository.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-or-surname")
    public List<Person> getAllPersonsByNameOrSurname(@RequestParam(required = false) Optional<String> name, @RequestParam(required = false) Optional<String> surname) {
        return this.personRepository.getPersonsByNameOrSurname(name, surname);
    }
}