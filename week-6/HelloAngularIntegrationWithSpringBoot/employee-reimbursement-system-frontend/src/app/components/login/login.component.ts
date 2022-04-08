import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorMessage: string;
  //fields/properties
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private loginService: LoginService) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });

    // Have LoginComponent subscribe to the loginErrorSubject that exists inside of the loginService object
    // Whenever something publishes to the loginErrorSubject, any subscriber will receive that information (callback function
    // will be invoked)
    this.loginService.loginErrorSubject.subscribe((errMsg) => {
      this.errorMessage = errMsg;
    });
  }

  loginUser(){
    //1. get login form data from the html form
    const user = this.loginForm.value;
    console.log(user);
    //2. sign user in
    this.loginService.authenicateUser(user.username, user.password);
  }

}
