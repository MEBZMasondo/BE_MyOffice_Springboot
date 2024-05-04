package com.example.crudbook;

import com.example.crudbook.model.Book;
import com.example.crudbook.repo.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// Only Controller here no service class
// TODO : Create and use service to work on records
@RestController
@RequestMapping("/api")  //base Url
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/getAllBooks")
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("/books/addBook")
    public HttpStatus addBook(@RequestBody Book book){
        bookRepository.save(book);
        return HttpStatus.CREATED;
    }

    @PutMapping("/books/updateBook/{id}")
    public HttpStatus update(@RequestBody Book updatedBook, @PathVariable Long id) {

        Optional<Book> existBook = bookRepository.findById(id);

        if (existBook.isPresent()) {
            Book existingBook = existBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());

            bookRepository.save(existingBook);
        }
            return HttpStatus.OK;
    }

    @DeleteMapping("/books/deleteBook/{id}")
    public HttpStatus deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return HttpStatus.OK;
    }

}
