import { Component, OnInit } from '@angular/core';
import { faker } from '@faker-js/faker';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  firstName: string = faker.name.firstName();
  lastName: string = faker.name.lastName();
  imageUrl: string = faker.image.avatar();

  output!: string;

  constructor() { }

  ngOnInit(): void {
  }

  generateImage() {
    this.imageUrl = faker.image.avatar();
  }

  someFunction(event: Event) {
    let inputElement: EventTarget = event.target!;

    this.output = (inputElement as HTMLInputElement).value;
  }

}
