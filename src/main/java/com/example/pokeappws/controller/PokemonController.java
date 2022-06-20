package com.example.pokeappws.controller;

import com.example.pokeappws.dto.PokemonDto;
import com.example.pokeappws.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("")
    public ResponseEntity<List<PokemonDto>> getPokemons(
            @RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok(pokemonService.findAll(name));
    }

    @PostMapping
    public ResponseEntity<PokemonDto> createPokemon(
            @RequestBody PokemonDto pokemonDto) {
        return ResponseEntity.ok(pokemonService.save(pokemonDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDto> updatePokemon(
            @PathVariable Integer id,
            @RequestBody PokemonDto pokemonDto) {
        return ResponseEntity.ok(pokemonService.update(pokemonDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Integer id) {
        pokemonService.delete(id);
        return ResponseEntity.ok().build();
    }
}
