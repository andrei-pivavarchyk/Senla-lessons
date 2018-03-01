import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../entity/book';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
   bookList:Book[]=[];
 books:string;

  constructor(
    private bookService: BookService
  ) { }

  ngOnInit() {
this.getAllBooks();

  }

  getAllBooks(): void {
    this.bookService.getAllBooks()
        .subscribe(result => this.bookList=result.body);
  }
}
