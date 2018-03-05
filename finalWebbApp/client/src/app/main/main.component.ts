import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../entity/book';
import { ChangeDetectionStrategy } from '@angular/core';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  bookList: Book[] = [];
  currentPage = 1;
  numberOfPages: number = 4;
  maxResults: number = 6;


  constructor(
    private bookService: BookService
  ) { }

  ngOnInit() {
    this.getAllBooks();
 

  }

  getAllBooks(): void {
    var first = this.currentPage * this.maxResults - this.maxResults + 1;
   
    this.bookService.getAllBooks(first-1, this.maxResults)
      .subscribe(result => this.bookList = result.body);
  }
  pageForward() {
  
    this.currentPage=this.currentPage+1;
    this.getAllBooks();
  
  }
  pageBack() {
    if (this.currentPage >= 2) {
      this.currentPage=this.currentPage - 1;
      this.getAllBooks();
    }


  }
}
