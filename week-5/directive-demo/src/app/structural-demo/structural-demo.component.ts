import { Component, OnInit } from '@angular/core';
import { faker } from '@faker-js/faker';
import { Person } from '../Person';

@Component({
  selector: 'app-structural-demo',
  templateUrl: './structural-demo.component.html',
  styleUrls: ['./structural-demo.component.css']
})
export class StructuralDemoComponent implements OnInit {

  isVisible: boolean = true;

  people: Person[] = [];

  currentItem: number = 1;

  constructor() {
    // Iterate 50 times
    for (let i = 0; i < 50; i++) {
      let firstName = faker.name.firstName();
      let lastName = faker.name.lastName();
      let email = faker.internet.email();

      this.people.push({ 'firstName': firstName, 'lastName': lastName, 'email': email });
    }
  }

  whenToggleButtonClicked() {
    this.isVisible = !this.isVisible;
  }

  ngOnInit(): void {
  }

}
