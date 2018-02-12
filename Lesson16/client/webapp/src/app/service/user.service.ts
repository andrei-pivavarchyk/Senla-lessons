import { Injectable } from '@angular/core';
import { User } from '../entity/user';
import { HttpClient, HttpHeaders, HttpHeaderResponse } from '@angular/common/http';
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
  public token: string;
  public res:Response;
  constructor(
    private http: HttpClient
  ) { 
          // set token if saved in local storage
          var currentUser = JSON.parse(localStorage.getItem('currentUser'));
          this.token = currentUser && currentUser.token;
  }


login(user:User): Observable<boolean> {

  return this.http.post(this.loginURL, JSON.stringify( { "type": "User","id": null, "login": user.login,  "password": user.password }),httpOptions)
  .map((response: Response) => {
      // login successful if there's a jwt token in the response
      let token = response.headers.get('Authorization');
      if (token) {
          // set token property
          this.token = token;
          // store username and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('token', this.token);
          // return true to indicate successful login
          return true;
      } else {
          // return false to indicate failed login
          console.log(this.token);
          return false;
      }
  }); 
}


logout(): void {
  // clear token remove user from local storage to log user out
  this.token = null;
  localStorage.removeItem('currentUser');
}
getString():void{
  this.http.get('http://localhost:8080/controller-1.0-SNAPSHOT/data',httpOptions).subscribe(resp => {
  console.log(777);
 });

}

}
