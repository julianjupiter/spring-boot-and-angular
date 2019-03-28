package io.github.julianjupiter.springbootandangular.service;

import io.github.julianjupiter.springbootandangular.domain.Hero;
import io.github.julianjupiter.springbootandangular.repository.HeroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

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
        return heroRepository.findByNameContainingIgnoreCase(name);
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
