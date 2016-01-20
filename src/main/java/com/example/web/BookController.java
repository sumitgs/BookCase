package com.example.web;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumit.suthar on 19/1/16.
 */

@RestController
@RequestMapping(value = "/books")
public class BookController  {
    private final BookRepository bookRepository;

    @Autowired
    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createBook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    Book createBook(@RequestBody Book book) {
        return this.bookRepository.create(book);
    }

    @RequestMapping(method = RequestMethod.GET, value="/showBook/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    Book retrieveBook(@PathVariable Long id) {
        Book book = this.bookRepository.retrieve(id);

        return book;
    }

    @RequestMapping(method = RequestMethod.GET, value="/showAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<Book> allBooks() {
        return this.bookRepository.retrieveAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/deleteBook/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    void deleteBook(@PathVariable Long id) {
        this.bookRepository.remove(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="updateBook/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Book update(@PathVariable Long id, @RequestBody Book book) {

        Book oldBook = this.bookRepository.retrieve(id);

        oldBook.setAuthor(book.getAuthor());
        oldBook.setBookName(book.getBookName());
        oldBook.setType(book.getType());

        return oldBook;
    }
}
