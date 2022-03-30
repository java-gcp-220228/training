import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'pipe-demo';

  someObject = { 'name': 'John', 'age': 28, 'occupation': 'Teacher' }

  someVariable!: number;
}
