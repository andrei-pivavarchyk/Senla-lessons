import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../entity/book';
import { BookService } from '../service/book.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

 

  constructor(   private router: Router
  ) {
    
   }
   ngOnInit() {
    this.router.navigate(['profile/userdata']);
  }


}
