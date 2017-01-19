package com.dmi.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * (Long id, String title, Double price, String link) 
	 * </p>
	 * 
	 * @return All books
	 */
	@RequestMapping(value = "/v1/items", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BookBase> getAllBooksWithRestrictedColums() {
		logger.info("> getAllBooksWithRestrictedColums");
		return transformObjectToBookBase(bookRepository.getAllBooksWithRestrictedColums());
	}

	/**
	 * 
	 * <p>
	 * 	Web service endpoint to fetch all books with all columns
	 * </p>
	 * 
	 * @return All books
	 */
	@RequestMapping(value = "/v2/items", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> getAllBooks() {
		logger.info("> getAllBooks");
		return bookRepository.findAll();
	}
	
	/**
	 * <p>
	 * Web service endpoint to fetch a single Book entity by primary key
	 * identifier.
	 * </p>
	 * <p>
	 * If found, the Book is returned as JSON with HTTP status 200. If not
	 * found, the service returns an empty response body with HTTP status 404.
	 * </p>
	 * 
	 * @param id
	 *            A Long URL path variable containing the Book primary key
	 *            identifier.
	 * @return A ResponseEntity containing a single Book object, if found, and a
	 *         HTTP status code as described in the method comment.
	 */
	@RequestMapping(value = "/v1/items/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBook(@PathVariable final Long id) {
		logger.info("> getBook");

		final Book book = bookRepository.findOne(id);
		if (book == null) {
			logger.info("< No books!");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		logger.info("< getBook");
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/v1/address", method = POST, headers =
	 * "Accept=application/vnd.company.app-v2+json")
	 * 
	 * @ResponseStatus(ACCEPTED) public void saveAddressAcceptV2(@ModelAttribute
	 * @Valid final AddressParamV2 addressParamV2) { Address address =
	 * convertFromV2(addressParamV2); addressService.save(address); }
	 */
	
	private List<BookBase> transformObjectToBookBase(List<Object[]> allBooksRestrictedColums) {
		List<BookBase> retList = new ArrayList<BookBase>();
		if (allBooksRestrictedColums != null && allBooksRestrictedColums.size() > 0) {
			for (int i = 0; i < allBooksRestrictedColums.size(); i++) {
				Object[] objects = allBooksRestrictedColums.get(i);
				retList.add(new BookBase(new Long(objects[0].toString()), objects[1].toString(),
						new Double(objects[2].toString()), objects[3].toString()));
			}
		}
		return retList;
	}
}
