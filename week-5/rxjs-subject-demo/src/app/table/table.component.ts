import { Component, Input, OnInit } from '@angular/core';
import { PokeService } from '../poke.service';
import { Pokemon } from '../Pokemon';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  items: Pokemon[] = [];
  pokeService: PokeService;

  // Dependency injection
  // Constructor injection
  constructor(pokeService: PokeService) {
    this.pokeService = pokeService;
  }

  ngOnInit(): void {
    // We are subscribing the TableComponent to the RxJS subject found in Poke Service
    // Whenever something publishes to that subject, any subscriber will receive that data
    // Here, we are taking that data and pushing it to our items array
    this.pokeService.subject.subscribe((poke) => {
      this.items.push(poke);
    });
  }

}
