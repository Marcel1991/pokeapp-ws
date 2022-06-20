package com.example.pokeappws.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author ACER on 19/06/2022
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "POKEMONS")
@Entity
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String imageUrl;

    private Integer attack;

    private Integer defense;
}
