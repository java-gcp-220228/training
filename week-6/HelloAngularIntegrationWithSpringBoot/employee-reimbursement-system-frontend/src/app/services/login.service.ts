import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { User } from '../models/user-model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private client: HttpClient, private router: Router) { }

  authenicateUser(username: string, password: string){
    this.client.post<User>(`${environment.BACKEND_URL}/login`, new User(username, password)).subscribe(
      data => {
        sessionStorage.setItem("user_info", JSON.stringify(data));
        console.log(sessionStorage.getItem("user_info"));
        this.router.navigate(['home']);
      }
    , error => {
      console.log("Error: " + error);
    })
  }
}
