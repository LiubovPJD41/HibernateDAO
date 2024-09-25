package ru.Polyaeva.hibernatedao.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.Polyaeva.hibernatedao.entities.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PersonRepository {
    private final EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private TypedQuery<Person> executeQuery(String queryString, Map<String, String> parameters) {
        TypedQuery<Person> query = this.entityManager.createQuery(queryString, Person.class);
        for (String parameter : parameters.keySet()) {
            query.setParameter(parameter, parameters.get(parameter));
        }
        return query;
    }

    public List<Person> getPersonsByCity(String city) {
        return this.executeQuery("SELECT person FROM Person person WHERE person.cityOfLiving = :city", Map.of("city", city)).getResultList();
    }

    public List<Person> getPersonsByAge(int age) {
        return this.executeQuery("SELECT person FROM Person person WHERE person.age < :age ORDER BY person.age ASC", Map.of("age", String.valueOf(age))).getResultList();
    }

    public List<Person> getPersonsByNameOrSurname(Optional<String> name, Optional<String> surname) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", name.orElse("NULL"));
        parameters.put("surname", surname.orElse("NULL"));
        return this.executeQuery(
                "SELECT person FROM Person person WHERE (name = COALESCE(:name, name) AND :name IS NOT NULL) OR (surname = COALESCE(:surname, surname) AND :surname IS NOT NULL)",
                parameters
        ).getResultList();
    }
}