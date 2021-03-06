package com.example.repository;

import com.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

/**
 * Created by sumit.suthar on 19/1/16.
 */
@Component
public class InMemoryBookRepository implements BookRepository {


    @Autowired
    MongoTemplate mongoTemplate;

    private final Map<Long, Book> books = new HashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Book create(Book book) {
        // Long id = this.idGenerator.getAndIncrement();
        //        this.books.put(book.getId(), book);
       // book.setId(id);

        mongoTemplate.insert(book);



        return book;
    }

    @Override
    public Book retrieve(Long id) {
//        if(!this.books.containsKey(id)) {
//            return null;
//        }

        return mongoTemplate.findOne(query(where("id").is(id)), Book.class);

    }

    @Override
    public List<Book> retrieveAll() {
//        if(!this.books.containsKey(id)) {
//            return null;
//        }

        return mongoTemplate.findAll(Book.class);

    }


    @Override
    public void remove(Long id) {
        mongoTemplate.remove(query(where("id").is(id)), Book.class);
    }

    public Book updateBook(Book book, Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("bookName", book.getBookName()).set("author", book.getAuthor()).set("type", book.getType());
        return mongoTemplate.findAndModify(query, update, Book.class);

    }


}
