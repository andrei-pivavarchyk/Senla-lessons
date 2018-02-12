import { Component, OnInit } from '@angular/core';
import { User } from '../entity/user';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { UserService } from '../service/user.service';
import { catchError, map, tap } from 'rxjs/operators';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

export class LoginFormComponent implements OnInit {
aut:Boolean;
  constructor(
    private http: HttpClient,
    private userService: UserService
  ) { }

  ngOnInit() {
    
  }
 
  private user: User = { "type": "User","id": null, "login": "s",  "password": "s" };
  private str:String;


  loginUser(): void {
this.userService.getString();
this.userService.login(this.user).
subscribe(data => this.aut=data);
  console.log(this.aut);
  }
  someText():void{
    console.log('blabla');
  }
}
