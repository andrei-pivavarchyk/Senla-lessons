import { Component, OnInit } from '@angular/core';
import {User} from '../entity/user';
import{UserService}from'../service/user.service' ;
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user:User={
    type:'User',
    id:1,
    login:'login',
    password:'password'
  }
  str:String;
  constructor(private userService:UserService) { }

  ngOnInit() {
   
  }

}
