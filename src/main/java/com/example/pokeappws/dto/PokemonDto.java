package com.example.pokeappws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ACER on 19/06/2022
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PokemonDto {

    private Integer id;
    private String name;
    private String imageUrl;
    private Integer attack;
    private Integer defense;
}
