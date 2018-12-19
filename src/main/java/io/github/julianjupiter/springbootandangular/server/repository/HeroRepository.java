package io.github.julianjupiter.springbootandangular.server.repository;

import io.github.julianjupiter.springbootandangular.server.domain.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    Iterable<Hero> findByNameContaining(String name);
}
