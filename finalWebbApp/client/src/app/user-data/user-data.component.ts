import { Component, OnInit } from '@angular/core';
import { UserData } from '../entity/userdata';
import { Address } from '../entity/address';
import { catchError, map, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { UserService } from '../service/user.service';
@Component({
  selector: 'user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.css']
})
export class UserDataComponent implements OnInit {

  constructor(
    private userService: UserService,

  ) { }

  ngOnInit() {
  }

  private user: UserData = 
 
    {
      "type": "UserData",
      "id": 1,
      "name": "Andrei",
      "surname": "White",
      "patronymic": "Hrumov",
      "role": "USER",
      "email": "andreyatake666@mailo.ru",
      "phone": 292816940,
      "address": null
  }
  private address:Address=
  {
    "type": "Address",
    "id": 1,
    "localAddress": "ул. Индивидуальная дом№6",
    "city": "Гродно",
    "region": "Гродненский",
    "country": "Беларусь",
    "index": 240000
}

  getUserData(): void {
   
  
    this.userService.getUserData()
        .subscribe(result => {
            if (result === true) {
             console.log(true)
            } else {
                // login failed
             //   this.error = 'Username or password is incorrect';
             console.log(false)
            }
          
        });

  }




  
}
