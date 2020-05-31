package io.github.julianjupiter.springbootandangular.dto;

public class HeroDto {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public HeroDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroDto setName(String name) {
        this.name = name;
        return this;
    }
}
