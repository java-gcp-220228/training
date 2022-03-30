import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-attribute-demo',
  templateUrl: './attribute-demo.component.html',
  styleUrls: ['./attribute-demo.component.css']
})
export class AttributeDemoComponent implements OnInit {

  lastSectionHoveredOver: number = 1;

  constructor() { }

  ngOnInit(): void {
  }

}
