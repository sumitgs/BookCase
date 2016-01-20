package com.example.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sumit.suthar on 20/1/16.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookDoesNotExistException extends Exception{
    BookDoesNotExistException(Long id) {
        super(String.format("Book %d does not exist", id));
    }
}
