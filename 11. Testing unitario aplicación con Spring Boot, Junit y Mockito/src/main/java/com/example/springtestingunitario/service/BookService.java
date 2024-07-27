package com.example.springtestingunitario.service;

import com.example.springtestingunitario.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
}
