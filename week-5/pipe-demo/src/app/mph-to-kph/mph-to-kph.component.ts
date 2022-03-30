import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mph-to-kph',
  templateUrl: './mph-to-kph.component.html',
  styleUrls: ['./mph-to-kph.component.css']
})
export class MphToKphComponent implements OnInit {

  inputValue: number = 0;
  mphToKph: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

}
