package ru.irendemchenkova.hibernatedao.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.irendemchenkova.hibernatedao.entities.Person;

import java.util.List;

@Repository
public class PersonRepository {
    private final EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        String jpql = "SELECT person FROM Person person WHERE person.cityOfLiving = :city";
        TypedQuery<Person> query = this.entityManager.createQuery(jpql, Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
