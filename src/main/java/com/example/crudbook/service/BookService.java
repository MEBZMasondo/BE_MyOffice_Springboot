package com.example.crudbook.service;

import com.example.crudbook.model.Book;
import com.example.crudbook.repo.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getBookAll() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void update(Book updatedBook, Long id) {
        Optional<Book> existBook = bookRepository.findById(id);

        if (existBook.isPresent()) {
            Book existingBook = existBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());

            bookRepository.save(existingBook);
        }
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
