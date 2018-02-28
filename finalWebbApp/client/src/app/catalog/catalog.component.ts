import { Component, OnInit } from '@angular/core';
import { BookService } from '../service/book.service';
import { Book } from '../entity/book';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  bookList:Book[];
  private bookService: BookService
  constructor() { 
    
  }

  ngOnInit() {
    this.getAllBooks();
  }


  getAllBooks(): void {
    this.bookService.getAllBooks()
        .subscribe(result => this.bookList=result.body);
  }
  
}
