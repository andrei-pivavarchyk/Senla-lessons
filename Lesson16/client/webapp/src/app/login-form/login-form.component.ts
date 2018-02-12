import { Component, OnInit } from '@angular/core';
import { User } from '../entity/user';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { UserService } from '../service/user.service';
import { catchError, map, tap } from 'rxjs/operators';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

export class LoginFormComponent implements OnInit {
  aut: Boolean;
  constructor(
    private http: HttpClient,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {

  }

  private user: User = { "type": "User", "id": null, "login": "s", "password": "s" };
  private load: boolean;


  loginUser(): void {


    this.load = false;
    this.userService.login(this.user)
    .subscribe(result => {
      if (result === true) {
          // login successful
          this.router.navigate(['/']);
          console.log('succes');
      } else {
          // login failed
         
          this.load = false;
          console.log( this.load);
      }
  });
   
  }
  someText(): void {
    console.log('blabla');
  }
}
