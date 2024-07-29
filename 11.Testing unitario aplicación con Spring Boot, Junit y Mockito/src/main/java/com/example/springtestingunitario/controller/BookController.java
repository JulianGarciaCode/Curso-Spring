package com.example.springtestingunitario.controller;

import com.example.springtestingunitario.service.BookService;
import com.example.springtestingunitario.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String findAll(Model model) {
        model.addAttribute("books", this.bookService.findAll());
        return "booksList";
    }

    @GetMapping("/books/{id}")
    public String findById(Long id, Model model) {
        Book book = this.bookService.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "bookView";
    }
}
