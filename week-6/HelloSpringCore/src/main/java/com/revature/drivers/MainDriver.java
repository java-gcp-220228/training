package com.revature.drivers;

import com.revature.models.Pokemon;
import com.revature.services.PokemonService;
import com.revature.services.PokemonServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainDriver {
    static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

    public static void main(String[] args) {
        //make a service bean
        PokemonService pokemonService = appContext.getBean(PokemonServiceImpl.class);

        //retrieve data
        List<Pokemon> list = pokemonService.getAll();

        System.out.println("List of my pokemon: \n");
        for (Pokemon pokemon: list) {
            System.out.println(pokemon + "\n");
        }
    }
}
