package io.github.julianjupiter.springbootandangular.controller;

import io.github.julianjupiter.springbootandangular.dto.HeroDto;
import io.github.julianjupiter.springbootandangular.dto.HeroRequestDto;
import io.github.julianjupiter.springbootandangular.entity.Hero;
import io.github.julianjupiter.springbootandangular.exception.ExceptionUtils;
import io.github.julianjupiter.springbootandangular.exception.ResourceNotFoundException;
import io.github.julianjupiter.springbootandangular.exception.ValidationException;
import io.github.julianjupiter.springbootandangular.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/heroes")
@CrossOrigin(origins = { "http://localhost:8091", "http://localhost:4200" }, maxAge = 3000)
public class HeroController {
    private HeroService heroService;
    @Autowired
    private MessageSource messageSource;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public Iterable<HeroDto> findAll(@RequestParam(value = "name", required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return heroService.findByName(name);
        }

        return heroService.findAll();
    }

    @PostMapping
    public ResponseEntity<HeroDto> create(@Valid @RequestBody HeroRequestDto heroRequestDto, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            ExceptionUtils.invalid(bindingResult, messageSource, ExceptionUtils.path());
        }

        return new ResponseEntity<>(heroService.save(heroRequestDto, 0), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public HeroDto findById(@PathVariable long id) throws Exception {
        return heroService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hero with ID " + id + " was not found", ExceptionUtils.path(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hero> update(@PathVariable long id, @Valid @RequestBody HeroRequestDto heroRequestDto, BindingResult bindingResult) throws ValidationException, ResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            ExceptionUtils.invalid(bindingResult, messageSource, ExceptionUtils.path());
        }

        return heroService.findById(id)
                .map(foundHero -> {
                    heroService.save(heroRequestDto, id);
                    return new ResponseEntity(HttpStatus.OK);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Hero with ID " + id + " was not found", ExceptionUtils.path(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hero> delete(@PathVariable long id) throws ResourceNotFoundException {
        return heroService.findById(id)
                .map(hero -> {
                    heroService.deleteById(id);
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Hero with ID " + id + " was not found", ExceptionUtils.path(id)));
    }
}
