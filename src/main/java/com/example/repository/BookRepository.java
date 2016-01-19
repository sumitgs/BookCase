package com.example.repository;

import com.example.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumit.suthar on 19/1/16.
 */
public interface BookRepository {
    Book create(Book book);

    Book retrieve(Long id);

    void remove(Long id);

    ArrayList<Book> retrieveAll();
}
