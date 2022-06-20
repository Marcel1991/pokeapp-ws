package com.example.pokeappws.service;

import com.example.pokeappws.domain.Pokemon;
import com.example.pokeappws.dto.PokemonDto;
import com.example.pokeappws.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ACER on 19/06/2022
 */
@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    @Override
    public List<PokemonDto> findAll(String name) {
        if (name == null || name.isEmpty()) {
            return pokemonRepository.findAll().stream()
                    .map(pokemon -> PokemonDto.builder()
                            .id(pokemon.getId())
                            .name(pokemon.getName())
                            .imageUrl(pokemon.getImageUrl())
                            .attack(pokemon.getAttack())
                            .defense(pokemon.getDefense())
                            .build())
                    .collect(Collectors.toList());
        } else {
            return pokemonRepository.findAllByNameContainingIgnoreCase(name).stream()
                    .map(pokemon -> PokemonDto.builder()
                            .id(pokemon.getId())
                            .name(pokemon.getName())
                            .imageUrl(pokemon.getImageUrl())
                            .attack(pokemon.getAttack())
                            .defense(pokemon.getDefense())
                            .build())
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void delete(Integer id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public PokemonDto save(PokemonDto pokemonDto) {
        Pokemon pokemon = Pokemon.builder()
                .name(pokemonDto.getName())
                .imageUrl(pokemonDto.getImageUrl())
                .attack(pokemonDto.getAttack())
                .defense(pokemonDto.getDefense())
                .build();
        pokemon = pokemonRepository.save(pokemon);
        return PokemonDto.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .imageUrl(pokemon.getImageUrl())
                .attack(pokemon.getAttack())
                .defense(pokemon.getDefense())
                .build();
    }

    @Override
    public PokemonDto update(PokemonDto pokemonDto) {
        Pokemon pokemon = pokemonRepository.findById(pokemonDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Pokemon not found"));

        pokemon.setName(pokemonDto.getName());
        pokemon.setImageUrl(pokemonDto.getImageUrl());
        pokemon.setAttack(pokemonDto.getAttack());
        pokemon.setDefense(pokemonDto.getDefense());

        pokemon = pokemonRepository.save(pokemon);

        return PokemonDto.builder()
                .id(pokemon.getId())
                .name(pokemonDto.getName())
                .imageUrl(pokemonDto.getImageUrl())
                .attack(pokemonDto.getAttack())
                .defense(pokemonDto.getDefense())
                .build();
    }
}
