package ru.Polyaeva.hibernatedao.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.Polyaeva.hibernatedao.entities.Person;
import ru.Polyaeva.hibernatedao.repositories.PersonRepository;


import java.util.List;

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
}
