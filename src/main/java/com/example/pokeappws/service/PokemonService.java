package com.example.pokeappws.service;

import com.example.pokeappws.dto.PokemonDto;

import java.util.List;

/**
 * @author ACER on 19/06/2022
 */
public interface PokemonService {

    List<PokemonDto> findAll(String name);

    void delete(Integer id);

    PokemonDto save(PokemonDto pokemonDto);

    PokemonDto update(PokemonDto pokemonDto);
}
