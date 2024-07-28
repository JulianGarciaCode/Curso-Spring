package com.example.springtestingunitario.service;

import com.example.springtestingunitario.entity.Book;
import com.example.springtestingunitario.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id).map(book -> {
            book.setTitle(book.getTitle().toUpperCase());
            return book;
        });
    }
}
