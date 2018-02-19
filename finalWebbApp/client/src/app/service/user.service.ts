import { Injectable } from '@angular/core';
import { User } from '../entity/user';
import { HttpClient, HttpHeaders, HttpHeaderResponse, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';
import { Http, Headers, Response } from '@angular/http';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};
const options =
  {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'my-auth-token'
    }),
    observe: 'response'
  };



@Injectable()
export class UserService {

  private loginURL = 'http://localhost:8080/controller-1.0-SNAPSHOT/login';
  private userDataUrl = 'http://localhost:8080/controller-1.0-SNAPSHOT/api/profile';
  public res: Response;
  constructor(
    private http: HttpClient
  ) {

  }


  logout(): void {
  
    localStorage.removeItem('currentUser');
  }


  login(user: User) {

      return this.http.post(this.loginURL,
        { "type": "User", "id": null, "login": user.login, "password": user.password },
      )
      .map((response: Response) => {
          // login successful if there's a jwt token in the response
          let token = response['token'];
          if (token) {
              localStorage.setItem('currentUser', token);
              return true;
          } else {
              // return false to indicate failed login
              return false;
          }
      });













  }
  getUserData() {
    return this.http.get(this.userDataUrl,
      {
        observe: 'response',
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': 'my-auth-token'
        })
      }
    )
      .subscribe(Response => {
        if (Response.body) {

          return true;
        }
        return false;

      });
  }

}
