import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable, resolveForwardRef } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserInfo } from '../models/user-info';
import { User } from '../models/user-model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginErrorSubject: Subject<string> = new Subject<string>();

  constructor(private client: HttpClient, private router: Router) { }

  getUserInfoFromJwt(): Observable<HttpResponse<UserInfo>> {
    return this.client.get<UserInfo>(`${environment.BACKEND_URL}/test`, {
      'observe': 'response',
      'headers': {
        'Authorization': `Bearer ${localStorage.getItem('jwt')}`
      }
    });
  }

  authenicateUser(username: string, password: string){
    this.client.post<User>(`${environment.BACKEND_URL}/login`, {
      'username': username,
      'password': password
    }, {
      'observe': 'response' // This option tells httpClient to give us the entire HttpResponse instead of just the response body,
      // which is what it would have done by default
    }).subscribe(
      res => {
        const jwt = res.headers.get('token');
        localStorage.setItem('jwt', jwt);

        // localStorage.setItem("user_info", JSON.stringify(res.body));
        // console.log(localStorage.getItem("user_info"));
        this.router.navigate(['home']);
      }
    , err => {
        const errorMessage = err.error;
        this.loginErrorSubject.next(errorMessage); // Publish information to the loginErrorSubject
    })
  }
}
