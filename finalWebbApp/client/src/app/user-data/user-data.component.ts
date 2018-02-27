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

  ) { 

 
  }

  ngOnInit() { 
this.getUserData();
  }


  private userData: UserData = 
    {
      "type": "UserData",
      "id": null,
      "name": null,
      "surname": null,
      "patronymic": null,
      "role": null,
      "email": null,
      "phone": null,
      "address": {
        "type": "Address",
        "id": null,
        "localAddress": null,
        "city": null,
        "region": null,
        "country": null,
        "index": null
    }
  }

  getUserData(): void {
    this.userService.getUserData()
        .subscribe(result => this.userData=  { ...result.body});
  }


}
