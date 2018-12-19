package io.github.julianjupiter.springbootandangular.server.service;

import io.github.julianjupiter.springbootandangular.server.domain.Hero;

import java.util.Optional;

public interface HeroService {
    Iterable<Hero> findAll();
    Optional<Hero> findById(long id);
    Iterable<Hero> findByName(String name);
    void save(Hero hero);
    void deleteById(long id);
}
