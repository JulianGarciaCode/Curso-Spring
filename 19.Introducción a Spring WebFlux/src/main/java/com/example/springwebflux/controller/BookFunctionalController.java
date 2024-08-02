package com.example.springwebflux.controller;

import com.example.springwebflux.model.Book;
import com.example.springwebflux.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;
//OTRA FORMA DE CONFIGURAR LA RUTA DE NUESTRA APP,
// CON API REACTIVA Y FUNCIONAL EN LUGAR DE ANOTACIONES
@Configuration
public class BookFunctionalController {

    @Autowired
    private BookService bookService;

    //RouterFunction es una interfaz funcional que permite definir rutas y
    //manejadores de peticiones para una aplicación web reactiva
    @Bean
    public RouterFunction<ServerResponse> findAllBooks(BookService bookService){
        return RouterFunctions.route().GET(
                "/functional/books",
                request -> ServerResponse.ok().body(bookService.findAll(), Book.class)
        ).build();
    }

    @Bean
    public RouterFunction<ServerResponse> findById(){
        return RouterFunctions.route().GET(
                "/functional/books/{id}",
                request -> ServerResponse.ok().body(
                        bookService.findById(Long.valueOf(request.pathVariable("id"))),
                        Book.class
                )
        ).build();
    }

    @Bean
    public RouterFunction<ServerResponse> createBook(){
        return RouterFunctions.route().POST(
                "/functional/books",
                request -> request.bodyToMono(Book.class)
                        .flatMap(bookService::create)
                        .flatMap(book ->
                                ServerResponse.created(URI.create("/functional/books" + book.getId()))
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(BodyInserters.fromValue(book))
                        )
        ).build();
    }

}
