package io.github.julianjupiter.springbootandangular.service;

import io.github.julianjupiter.springbootandangular.domain.Hero;

import java.util.Optional;

public interface HeroService {
    Iterable<Hero> findAll();
    Optional<Hero> findById(long id);
    Iterable<Hero> findByName(String name);
    void save(Hero hero);
    void deleteById(long id);
}
