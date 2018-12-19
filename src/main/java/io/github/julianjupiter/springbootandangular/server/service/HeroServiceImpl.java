package io.github.julianjupiter.springbootandangular.server.service;

import io.github.julianjupiter.springbootandangular.server.domain.Hero;
import io.github.julianjupiter.springbootandangular.server.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Iterable<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Optional<Hero> findById(long id) {
        return heroRepository.findById(id);
    }

    @Override
    public Iterable<Hero> findByName(String name) {
        return heroRepository.findByNameContaining(name);
    }

    @Override
    public void save(Hero hero) {
        heroRepository.save(hero);
    }

    @Override
    public void deleteById(long id) {
        heroRepository.deleteById(id);
    }
}
