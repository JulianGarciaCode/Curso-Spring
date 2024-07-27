package com.example.springtestingunitario.service;

import com.example.springtestingunitario.entity.Book;
import com.example.springtestingunitario.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    //Cargamos System under text: SUT
    BookService bookService;

    /*
    Dependencias de forma fictícia con @Mock(entre otros,
    pero más sofísticado y más opciones) creamos un objeto fictício
    con capacidades de verificación y comprobación reemplazando al objeto
    real
     */
    @Mock
    BookRepository bookRepository;

    /*
    @BeforeEach configura los objetos @Moks durante la creación
    de cada test, antes de iniciarlo para crearlas

     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    void findAll() {

        //Configurar sock
        when(bookRepository.findAll()).thenReturn(List.of());

        //Ejecutar comportamiento a testear
        List<Book> books = bookService.findAll();

        //Comprobaciones de JUnit
        assertNotNull(books);
        assertEquals(0, books.size());
        //Verificaciones Mockito que se ha ejecutado 1 vez
        verify(bookRepository, times(1)).findAll();

        /*
        Otros ejemplos con  Mockito:

        Comprobar que nunca ha llamado a un determinado método
        verify(bookRepository, never()).findAll();

        Comprobar que ha llamado a un determinado método al menos 3 veces
        verify(bookRepository, atLeast(3)).findAll();
        */


    }

    @Test
    void findById() {
    }

    @Test
    void findByIdFound() {
        //Configurar Mock
        when(bookRepository.findById(any())).thenReturn(Optional.of(new Book(1L, "book1", "description")));

        //Ejecutar el comportamiento a testear
        Optional<Book> bookOpt = bookService.findById(1L);

        //Comprobaciones JUnit
        assertNotNull(bookOpt);
        assertTrue(bookOpt.isPresent());
        assertEquals("BOOK1", bookOpt.get().getTitle());

        //Verificaciones de Mockito
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void findByIdNotFound() {
    }

    @Test
    void findByIdWrong() {
    }
}