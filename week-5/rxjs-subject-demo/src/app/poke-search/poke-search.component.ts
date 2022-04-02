import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { PokeService } from '../poke.service';
import { Pokemon } from '../Pokemon';

@Component({
  selector: 'app-poke-search',
  templateUrl: './poke-search.component.html',
  styleUrls: ['./poke-search.component.css']
})
export class PokeSearchComponent implements OnInit {

  pokeService: PokeService;
  pokemonIdInputValue!: number;

  // Dependency injection
  // (Specifically Constructor injection)
  constructor(pokeService: PokeService) {
    this.pokeService = pokeService;
  }

  ngOnInit(): void {
  }

  getAndAddPokemon() {
    if (this.pokemonIdInputValue) {
      this.pokeService.getPokemonById(this.pokemonIdInputValue).subscribe((pokemon) => {
        this.pokeService.subject.next(pokemon); // Publish the pokemon to the subject
      });
    }
  }

}
