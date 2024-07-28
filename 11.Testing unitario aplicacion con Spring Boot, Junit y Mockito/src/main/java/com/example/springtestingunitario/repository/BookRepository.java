package com.example.springtestingunitario.repository;

import com.example.springtestingunitario.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {

}
