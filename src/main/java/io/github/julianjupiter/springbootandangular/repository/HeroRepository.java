package io.github.julianjupiter.springbootandangular.repository;

import io.github.julianjupiter.springbootandangular.domain.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    Iterable<Hero> findByNameContainingIgnoreCase(String name);
}
