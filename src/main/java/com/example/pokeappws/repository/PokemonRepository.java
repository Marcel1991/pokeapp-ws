package com.example.pokeappws.repository;

import com.example.pokeappws.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ACER on 19/06/2022
 */
@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    List<Pokemon> findAllByNameContainingIgnoreCase(String name);
}
