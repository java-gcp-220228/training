import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-two-way-databinding-demo',
  templateUrl: './two-way-databinding-demo.component.html',
  styleUrls: ['./two-way-databinding-demo.component.css']
})
export class TwoWayDatabindingDemoComponent implements OnInit {

  output!: string;

  constructor() { }

  ngOnInit(): void {
  }

}
