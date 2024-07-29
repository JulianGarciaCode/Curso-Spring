package com.example.springcrudthymeleaf;

import com.example.springcrudthymeleaf.entity.Book;
import com.example.springcrudthymeleaf.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.Repository;

import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(App.class, args);
		var repo = context.getBean(BookRepository.class);

		List<Book> books = List.of(
				new Book(null, "book1", "JulianGarciaCode", 10.0),
				new Book(null, "book2", "Author2", 15.0),
				new Book(null, "book3", "Author3", 20.0),
				new Book(null, "book4", "Author4", 25.0)
		);
		repo.saveAll(books);
	}

}
