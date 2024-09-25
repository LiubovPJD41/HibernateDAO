package ru.irendemchenkova.hibernatedao.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONS")
@IdClass(PersonId.class)
public class Person {
    @Id
    @Column(length = 100)
    public String name;

    @Id
    @Column(length = 100)
    public String surname;

    @Id
    @Column
    public int age;

    @Column(length = 10)
    public String phoneNumber;

    @Column(length = 30)
    public String cityOfLiving;
}
