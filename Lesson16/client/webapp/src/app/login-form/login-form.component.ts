import { Component, OnInit } from '@angular/core';
import { User } from '../entity/user';

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  constructor(
    private http: HttpClient

  ) { }
  defaultUser:User={
    id:null,
    login:null,
    password:null
  };

  ngOnInit() {

  }

  private heroesUrl = 'api/heroes';
  user: User;

  onSelect(user: User): void {
    this.user = user;

  }





}
