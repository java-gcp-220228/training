import { Component } from '@angular/core';
import { Pokemon } from './Pokemon';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'parent-child-communication-demo';

  pokemons: Pokemon[] = [];

  constructor() {
  }

}
