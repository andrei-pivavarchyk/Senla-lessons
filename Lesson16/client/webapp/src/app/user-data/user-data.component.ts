import { Component, OnInit } from '@angular/core';
import { User } from '../entity/user';
@Component({
  selector: 'user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.css']
})
export class UserDataComponent implements OnInit {

  constructor() { }


  defaultUser:User={
    id:1,
    login:"bob",
    password:"password"
  };
  ngOnInit() {
  }

}
