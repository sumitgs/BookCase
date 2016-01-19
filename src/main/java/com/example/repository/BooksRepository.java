package com.example.repository;

import com.example.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sumit.suthar on 19/1/16.
 */

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface BooksRepository extends MongoRepository<Book, Long> {

    Book findById(@Param("id") Long id);

    List<Book> findAll();
}
