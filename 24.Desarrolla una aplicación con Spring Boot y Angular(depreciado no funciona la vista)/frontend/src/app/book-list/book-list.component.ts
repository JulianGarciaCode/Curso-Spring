import {Component, OnInit} from '@angular/core';
import {Book} from "../models/book";
import {BookService} from "../services/book-service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit{

  books?: Book[];

  constructor(private bookService: BookService) {
  }

  ngOnInit(): void {
    this.fetchBooks();
  }

  private fetchBooks() {
    this.bookService.findAll().subscribe({
      next: value => {
        this.books = value
        console.log(value)
      },
      error: error => {console.log(error)}
    })
  }
}
