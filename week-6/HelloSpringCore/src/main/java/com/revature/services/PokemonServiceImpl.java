package com.revature.services;

import com.revature.daos.PokemonDao;
import com.revature.models.Pokemon;

import java.util.List;

public class PokemonServiceImpl implements PokemonService{

    private PokemonDao pokeDao;

    //making default constructor for setter injection that is coming later
    public PokemonServiceImpl(){}

    //constructor injection example
    public PokemonServiceImpl(PokemonDao pokemonDao){
        this.pokeDao = pokemonDao;
    }

    //setter injection example
    public void setPokeDao(PokemonDao pokeDao){
        this.pokeDao = pokeDao;
    }


    @Override
    public List<Pokemon> getAll() {
        return pokeDao.getAllPokemon();
    }
}
