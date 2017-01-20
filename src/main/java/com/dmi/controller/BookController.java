package com.dmi.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmi.domain.Book;
import com.dmi.domain.BookBase;
import com.dmi.repository.BookRepository;

/**
 * <h3>DMI Robson's Test</h3>
 * 
 * Web service endpoint class to offer operations in Book entity
 * 
 * @author Robson Martins
 *
 */
@Controller
@RequestMapping("/api")
public class BookController extends DMIController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;

	/**
	 * 
	 * <p>
	 * 	Web service endpoint to fetch all books with restricted colums,
	 *  
	 *  @Vesion 1 only some attributes (Long id, String title, Double price, String link)
	 *   
	 * </p>
	 * 
	 * @return All books
	 */
	@RequestMapping(value = "/v1/items", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<BookBase>> getAllBooksWithRestrictedColums() {
		logger.info(".....getAllBooksWithRestrictedColums");
		return new ResponseEntity<Collection<BookBase>>(bookRepository.getAllBooksWithRestrictedColums(), HttpStatus.OK);
	}

	/**
	 * 
	 * <p>
	 * 	Web service endpoint to fetch all books with all columns
	 * 	
	 * 	@Vesion 2 Has all Book attributes
	 *  
	 * </p>
	 * 
	 * @return All books
	 */
	@RequestMapping(value = "/v2/items", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Collection<Book>> getAllBooks() {
		logger.info(".....getAllBooks");
		return new ResponseEntity<Collection<Book>>(bookRepository.findAll(), HttpStatus.OK);
	}
	
	/**
	 * <p>
	 * Web service endpoint to fetch a single Book entity by primary key identifier.
	 * </p>
	 * 
	 * @param id, it is a long Book's primary key identifier.
	 * @return A ResponseEntity containing a single Book object, if found
	 * 
	 */
	@RequestMapping(value = "/v1/items/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBook(@PathVariable final Long id) {
		logger.info(".....getBook");

		final Book book = bookRepository.findOne(id);
		if (book == null) {
			logger.info(".....No books!");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/**
	 * <p>
	 * Web service endpoint to create a new Book.
	 * </p>
	 * 
	 */
	@RequestMapping(value = "/v1/items", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> createBook(@RequestBody final Book book) {
		logger.info(".....createBook");
		final Book saved = bookRepository.save(book);
		setNullParamsBook(saved);
		bookRepository.save(saved);
		return new ResponseEntity<Book>(saved, HttpStatus.CREATED);
	}

	/**
	 * <p>
	 * Web service endpoint to update an existing Book.
	 * </p>
	 */
	@RequestMapping(value = "/v1/items/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@PathVariable("id") final Long id, @Valid @RequestBody final Book book) {
		logger.info(".....updateBook");
		
		final Book bookSearsh = bookRepository.findOne(id);
		if (bookSearsh == null) {
			logger.info(".....No books!");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		
		book.setId(id);
		setNullParamsBook(book);
		bookRepository.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/**
	 * <p>
	 * Web service endpoint to delete an existing Book.
	 * </p>
	 */
	@RequestMapping(value = "/v1/items/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable("id") final Long id) {
		logger.info(".....deleteBook");
		bookRepository.delete(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
    
	private void setNullParamsBook(final Book book) {
		book.setLink("/api/v1/items/"+book.getId());
		book.setImage("http://assignment.gae.golgek.mobi/static/"+book.getId()+".jpg");
	}
	
}
