import { Injectable } from '@angular/core';
import { User } from '../entity/user';
import { HttpClient, HttpHeaders, HttpHeaderResponse, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';
import { Http, Headers, Response } from '@angular/http';
import { UserData } from '../entity/userdata';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
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
private mainUrl='http://localhost:8080/controller-1.0-SNAPSHOT';
  private loginURL = this.mainUrl+'/login';
  private userDataUrl = this.mainUrl+'/api/profile';
  private registrationUrl = this.mainUrl+'/registration';
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
        {observe:'response' }
      )
      .map((response: HttpResponse<any>) => {
     
          let token =response.headers.get('authorization');
          if (token) {
              localStorage.setItem('currentUser', token);
              return true;
          } else {
              // return false to indicate failed login
              return false;
          }
      });

  }
  
  registration(login:String,password:String) {

    return this.http.post(this.registrationUrl,
      { "type": "User", "id": null, "login": login, "password": password , user_active:true},
      {observe:'response'}
    )
    .map((response: HttpResponse<any>) => {
   
        var status=response.status;
        if (status) {
          
            return true;
        } else {
        
            return false;
        }
    });

}

  getUserData():Observable<HttpResponse<UserData>> {
    return this.http.get(this.userDataUrl,
      {observe:'response'}
    )
    .map((response: HttpResponse<any>) => {
   
        var status=response.status;
        if (status) {
          console.log(response.body);
            return response;
        } else {
        
            return null;
        }
    });
  }
}
