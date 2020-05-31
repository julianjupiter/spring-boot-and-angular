package io.github.julianjupiter.springbootandangular.service;

import io.github.julianjupiter.springbootandangular.dto.HeroDto;
import io.github.julianjupiter.springbootandangular.dto.HeroRequestDto;
import io.github.julianjupiter.springbootandangular.entity.Hero;
import io.github.julianjupiter.springbootandangular.mapper.HeroMapper;
import io.github.julianjupiter.springbootandangular.repository.HeroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final HeroMapper heroMapper;

    public HeroServiceImpl(HeroRepository heroRepository, HeroMapper heroMapper) {
        this.heroRepository = heroRepository;
        this.heroMapper = heroMapper;
    }

    @Override
    public Iterable<HeroDto> findAll() {
        return heroRepository.findAll().stream()
                .map(heroMapper::fromEntityToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Optional<HeroDto> findById(long id) {
        return heroRepository.findById(id)
                .map(heroMapper::fromEntityToDto);
    }

    @Override
    public Iterable<HeroDto> findByName(String name) {
        return StreamSupport.stream(heroRepository.findByNameContainingIgnoreCase(name).spliterator(), false)
                .map(heroMapper::fromEntityToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public HeroDto save(HeroRequestDto heroRequestDto, long id) {
        Hero hero = heroMapper.fromDtoToEntity(heroRequestDto);
        if (id > 0) {
            hero.setId(id);
        }

        Hero savedHero = heroRepository.save(hero);

        return heroMapper.fromEntityToDto(savedHero);
    }

    @Override
    public void deleteById(long id) {
        heroRepository.deleteById(id);
    }
}
