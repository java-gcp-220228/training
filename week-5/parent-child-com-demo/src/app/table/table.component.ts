import { Component, Input, OnInit } from '@angular/core';
import { Pokemon } from '../Pokemon';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input() // The Input decorator treats the variable as an attribute for the component tag
  items!: Pokemon[];

  constructor() { }

  ngOnInit(): void {
  }

}
