package io.github.julianjupiter.springbootandangular.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public Hero setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }
}
