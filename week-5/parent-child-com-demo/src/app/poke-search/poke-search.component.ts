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

  @Output() // poke is now considered a custom event that could be emitted from this component (through the component tag)
  poke: EventEmitter<Pokemon> = new EventEmitter<Pokemon>();

  // Dependency injection
  // (Specifically Constructor injection)
  constructor(pokeService: PokeService) {
    this.pokeService = pokeService;
  }

  ngOnInit(): void {
  }

  getAndAddPokemon() {

    if (this.pokemonIdInputValue) {
      let obs: Observable<Pokemon> = this.pokeService.getPokemonById(this.pokemonIdInputValue);

      // subscribe is similar to .then() and .catch() for Promises
      // next corresponds to the callback function passed into .then(...)
      // error corresponds to the callback function passed into .catch(...)
      obs.subscribe({
        "next": (data) => {
          this.poke.emit(data);
        },
        "error": (err) => {
          console.log(err);
        }
      });

    }
  }

}
