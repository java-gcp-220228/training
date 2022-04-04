package com.revature.daos;

import com.revature.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonDaoImpl implements PokemonDao{
    @Override
    public List<Pokemon> getAllPokemon() {
        List<Pokemon> dbPokemon = new ArrayList<>();

        dbPokemon.add(new Pokemon(1, "pikachu", "electric", 1500));
        dbPokemon.add(new Pokemon(2, "abra", "psychic", 20));
        dbPokemon.add(new Pokemon(3, "psyduck", "water", 900));
        dbPokemon.add(new Pokemon(4, "gastly", "ghost", 1200));
        dbPokemon.add(new Pokemon(5, "arceus", "normal", 1200000));
        dbPokemon.add(new Pokemon(6, "charmeleon", "fire", 2500));

        return dbPokemon;
    }
}
