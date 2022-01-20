package com.pjatk.cemetery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Corpse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;

    private int ageWhenDied;

    private Sex sex;

    public Corpse() {

    }

    public Corpse(Integer id, String name, String surname, int ageWhenDied, Sex sex) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ageWhenDied = ageWhenDied;
        this.sex = sex;
    }
    // id getters and setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    // name getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // surname getters and setters
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    // ageWhenDied getters and setters
    public int getAgeWhenDied() {
        return ageWhenDied;
    }

    public void setAgeWhenDied(int ageWhenDied) {
        this.ageWhenDied = ageWhenDied;
    }
    // sex getters and setters
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Coprse{" +
                "id = " + this.id +
                ", name = " + this.name +
                ", surname = " + this.surname +
                ", ageWhenDied = " + this.ageWhenDied +
                ", sex = " + this.sex +
                "}";
    }
}
