package com.example.repository;

import com.example.model.Book;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sumit.suthar on 19/1/16.
 */
@Component
public class InMemoryBookRepository implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Book create(Book book) {
        Long id = this.idGenerator.getAndIncrement();

        book.setId(id);

        this.books.put(id, book);

        System.out.println("book is created my lord");

        return book;
    }

    @Override
    public Book retrieve(Long id) {
        if(!this.books.containsKey(id)) {
            return null;
        }

        System.out.println("woo hoo i am here");

        return this.books.get(id);
    }

    public ArrayList<Book> retrieveAll() {
        ArrayList<Book> list = new ArrayList<Book>(books.values());

        return list;
    }

    @Override
    public void remove(Long id) {
        this.books.remove(id);
    }


}
