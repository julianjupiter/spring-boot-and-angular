package io.github.julianjupiter.springbootandangular.dto;

import javax.validation.constraints.NotBlank;

public class HeroRequestDto {
    @NotBlank(message = "{NotBlank.heroRequestDto.name}")
    private String name;

    public String getName() {
        return name;
    }

    public HeroRequestDto setName(String name) {
        this.name = name;
        return this;
    }
}
