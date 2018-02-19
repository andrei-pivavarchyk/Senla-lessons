import { Component, OnInit } from '@angular/core';
import { User } from '../entity/user';
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
  getUserData(): void {
    this.userService.getUserData();
  }
}
