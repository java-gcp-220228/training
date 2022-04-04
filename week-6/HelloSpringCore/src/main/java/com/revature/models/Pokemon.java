package com.revature.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pokemon {
    private int id;
    private String pokemonName;
    private String pokeType;
    private int attackPower;
}
