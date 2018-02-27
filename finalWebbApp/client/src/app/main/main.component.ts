import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../entity/book';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
   bookList:Book[]=[
    {
      id: null,
      bookName: "name",
      bookCost: 100,
      genre: "FANTASTIC",
      bookStatus: "IN_STOCK",
      bookDescription: "Хорошая книга",
      feedbackList: null,
      author: null
  }

    ];
 books:string;

  constructor(
    private bookService: BookService
  ) { }

  ngOnInit() {


  }







  getAllBooks(): void {
    this.bookService.getAllBooks()
        .subscribe(result => this.books=  { ...result.body});
  }






}
