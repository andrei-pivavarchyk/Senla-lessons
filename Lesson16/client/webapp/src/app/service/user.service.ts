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


@Injectable()
export class UserService {

  private loginURL = 'http://localhost:8080/controller-1.0-SNAPSHOT/login';
  private userDataUrl = 'http://localhost:8080/controller-1.0-SNAPSHOT/api/profile';
  public token: string;
  public res: Response;
  constructor(
    private http: HttpClient
  ) {

  }


  logout(): void {
    // clear token remove user from local storage to log user out
    this.token = null;
    localStorage.removeItem('currentUser');
  }


  login(user: User) {
    return this.http.post(this.loginURL,
      { "type": "User", "id": null, "login": user.login, "password": user.password }
      ,
      { observe: 'response' }
    )
      .subscribe(resp => {
        if (resp.body['token']) {
          localStorage.setItem('currentUser', resp.body['token']);
          return true;
        }
        return false;

      });
  }
  getUserData(){
    return this.http.get(this.userDataUrl,
      { observe: 'response' }
    )
      .subscribe(resp => {
        if (resp.body) {
          console.log(localStorage.getItem('currentUser'));
         console.log(resp.body);
          return true;
        }
        return false;

      });


  }

}
