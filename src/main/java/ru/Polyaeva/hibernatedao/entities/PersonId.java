package ru.irendemchenkova.hibernatedao.entities;

import java.util.Objects;

public class PersonId {
    public String name;
    public String surname;
    public int age;

    public PersonId(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof PersonId)) {
            return false;
        }

        PersonId id = (PersonId) o;
        return id.name == this.name && id.surname == this.surname && id.age == this.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.age);
    }
}

