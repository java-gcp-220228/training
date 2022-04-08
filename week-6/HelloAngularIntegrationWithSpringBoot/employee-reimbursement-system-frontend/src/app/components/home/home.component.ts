import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username: any;

  constructor() { 
    const userInfo = sessionStorage.getItem("user_info");
    const user = JSON.parse(userInfo);
    this.username = user.username;
    console.log(user);
  }

  ngOnInit(): void {
  }

}
