package com.example.springwebflux.service;

import com.example.springwebflux.model.Book;
import com.example.springwebflux.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Mono<Book> findById(Long id){
        return this.repository.findById(id);
    }

    //Usamos Flux para devoler más de un resultado de 1-n resultados
    public Flux<Book> findAll(){
        return this.repository.findAll();
    }

    //Creamos un método para crear id que corresponda al guardar un id, si no está se crea a continuación
    //de los datos que tengan
    public Mono<Book> create(Book book){
        if(book.getId() != null)
            return Mono.error(new IllegalArgumentException("Id no debe ser nulo"));

            return this.repository.save(book);
    }

    public Mono<Book> update(Book book){
        if(book.getId() == null)
            return Mono.error(new IllegalArgumentException("Id debe ser nulo"));
        return this.repository.existById(book.getId()).flatMap(exist ->
                exist ? this.repository.save(book) :
                        Mono.error(new IllegalArgumentException("Book debe existir")));
    }

    public Mono<Void> deleteById(Long id){
        return this.repository.deleteById(id);
    }

    public Mono<Void> deleteAll(){
        return this.repository.deleteAll();
    }

}
