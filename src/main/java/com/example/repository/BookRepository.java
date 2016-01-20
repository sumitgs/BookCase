package com.example.repository;

import com.example.model.Book;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sumit.suthar on 19/1/16.
     */

public interface BookRepository  {

    public Book create(Book book);
    public Book retrieve(Long id);
    public void remove(Long id);
    public List<Book> retrieveAll();
    public Book updateBook(Book book, Long id);
}
