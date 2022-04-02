import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Pokemon } from './Pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokeService {

  http: HttpClient;

  subject: Subject<Pokemon> = new Subject<Pokemon>();

  constructor(http: HttpClient) {
    this.http = http;
  }

  // This function returns an Observable
  // An Observable is similar to a Promise except it can theoretically emit multiple values over time
  // In the case of an HTTP request, however, it will only emit one value
  // So in essence, for this purpose, it's pretty much the same as a Promise
  getPokemonById(id: number): Observable<Pokemon> {
    return this.http.get<Pokemon>(`https://pokeapi.co/api/v2/pokemon/${id}`, {})
  }

}
