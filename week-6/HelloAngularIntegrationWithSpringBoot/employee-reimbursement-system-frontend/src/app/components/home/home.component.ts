import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserInfo } from 'src/app/models/user-info';
import { User } from 'src/app/models/user-model';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username: any;

  constructor(private loginService: LoginService, private router: Router) {
  }

  ngOnInit(): void {
    this.loginService.getUserInfoFromJwt().subscribe((res) => {
      const userInfo: UserInfo = res.body;

      this.username = userInfo.username;
    }, err => {
      if (err.status === 401) {
        this.router.navigate(['/login']);
      }
    });
  }

}
