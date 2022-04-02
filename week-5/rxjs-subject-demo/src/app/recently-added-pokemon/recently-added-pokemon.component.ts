import { Component, OnInit } from '@angular/core';
import { PokeService } from '../poke.service';
import { Pokemon } from '../Pokemon';

@Component({
  selector: 'app-recently-added-pokemon',
  templateUrl: './recently-added-pokemon.component.html',
  styleUrls: ['./recently-added-pokemon.component.css']
})
export class RecentlyAddedPokemonComponent implements OnInit {

  recentPokemon!: Pokemon;
  pokeService: PokeService;

  // Dependency injection
  constructor(pokeService: PokeService) {
    this.pokeService = pokeService;
  }

  ngOnInit(): void {
    this.pokeService.subject.subscribe((poke) => {
      this.recentPokemon = poke;
    });
  }

}
