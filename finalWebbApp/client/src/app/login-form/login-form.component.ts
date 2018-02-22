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

  private user: User = { "type": "User", "id": null, "login": null, "password": null };
 

  loginUser(): void { 

   var login=true;
    this.userService.login(this.user)
        .subscribe(result => {
            if (result === true) {
        
              this.router.navigate(['home']);
            } else {
                // login failed
             //   this.error = 'Username or password is incorrect';
              login = false;
            }
          
        });

        console.log(localStorage.getItem('currentUser'));
  }
}
