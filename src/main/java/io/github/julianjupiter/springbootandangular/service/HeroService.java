package io.github.julianjupiter.springbootandangular.service;

import io.github.julianjupiter.springbootandangular.dto.HeroDto;
import io.github.julianjupiter.springbootandangular.dto.HeroRequestDto;

import java.util.Optional;

public interface HeroService {
    Iterable<HeroDto> findAll();
    Optional<HeroDto> findById(long id);
    Iterable<HeroDto> findByName(String name);
    HeroDto save(HeroRequestDto heroRequestDto, long id);
    void deleteById(long id);
}
