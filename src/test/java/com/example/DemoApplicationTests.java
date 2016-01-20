package com.example;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void shouldCreateBook(){
		Book b = bookRepository.create(createBook());
		assertThat(b.getAuthor(), is(createBook().getAuthor()));
	}

	@After
	public void deleteCreateBook() {
		bookRepository.remove(createBook().getId());
	}

	@Test
	public void shouldGetBook() {
		Book b = bookRepository.create(createBook());
		Book b2 = bookRepository.retrieve(b.getId());
		assertThat(b2.getBookName(), is(b.getBookName()));
	}



	private Book createBook(){
		final Book book = new Book();
		book.setAuthor("Victor Hugo");
		book.setType("novel");
		book.setBookName("les miserables");
		book.setId(101);
		return book;
	}

}
