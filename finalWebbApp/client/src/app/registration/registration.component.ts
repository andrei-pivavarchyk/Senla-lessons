import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(
    private userService: UserService,
    private router: Router) {

  }

  ngOnInit() {

  }
  private password = null;
  private repeatPassword = null;
  private login = null;


  registration(): void {

    this.userService.registration(this.login, this.password)
      .subscribe(result => {
        if (result === true) {
          this.router.navigate(['home']);
          console.log('registration succes')
        } else {
          console.log('registration fail')
        }
      });
  }

}
