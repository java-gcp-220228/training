import { Component } from '@angular/core';
import { faker } from '@faker-js/faker';
import { Person } from './Person';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  structuralDemoComponentDisplayed: boolean = false;
  attributeDemoComponentDisplayed: boolean = false;
}
