package com.example.crudbook.controller;

import com.example.crudbook.model.Book;
import com.example.crudbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")  //base Url
public class BookController {

    @Autowired
    BookService bookService;
    //public BookController(BookService bookService) {
    //  this.bookService = bookService;
    //}

    @GetMapping("/books/getAllBooks")
    public Iterable<Book> getAllBooks() {
        return bookService.getBookAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/books/addBook")
    public HttpStatus addBook(@RequestBody Book book){
        bookService.addBook(book);
        return HttpStatus.CREATED;
    }

    @PutMapping("/books/updateBook/{id}")
    public HttpStatus updateBook(@RequestBody Book updatedBook, @PathVariable Long id) {
        bookService.update(updatedBook, id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/books/deleteBook/{id}")
    public HttpStatus deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return HttpStatus.NO_CONTENT;
    }

}
