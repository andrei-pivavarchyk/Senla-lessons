import { Component, OnInit } from '@angular/core';
import { Book } from '../entity/book';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-profilebook',
  templateUrl: './profilebook.component.html',
  styleUrls: ['./profilebook.component.css']
})
export class ProfilebookComponent implements OnInit {
  bookList: Book[] = [];
  constructor(  private bookService: BookService) { }

  ngOnInit() {
    this.getAllBooks();
  }
  getAllBooks(): void {
 
   
    this.bookService.getAllBooks(1,2)
      .subscribe(result => this.bookList = result.body);
  }
}
