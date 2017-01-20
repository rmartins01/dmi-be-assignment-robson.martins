package com.dmi.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.dmi.AbstractControllerTest;
import com.dmi.domain.Book;
import com.dmi.repository.BookRepository;

/**
 * <p>
 * Unit tests using Spring MVC Mocks.
 * </p>
 * 
 * @author Robson Martins
 */
@Transactional
public class BookControllerTest extends AbstractControllerTest {

	private static final String VERSION = "/v1";
	private static final String RESOURCE_URI = "/api" + VERSION + "/items";

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testAllBooks() throws Exception {

		final MvcResult result = mvc.perform(
				MockMvcRequestBuilders.get(RESOURCE_URI).accept(MediaType.APPLICATION_JSON))
				.andReturn();

		final String content = result.getResponse().getContentAsString();
		final int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value",
				(content != null && !content.isEmpty()));
	}

	@Test
	public void testSpecificBook() throws Exception {

		final MvcResult result = mvc.perform(
				MockMvcRequestBuilders.get(RESOURCE_URI, new Long(1)).accept(
						MediaType.APPLICATION_JSON)).andReturn();

		final String content = result.getResponse().getContentAsString();
		final int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value",
				(content != null && !content.isEmpty()));
	}

	@Test
	public void testCreateBook() throws Exception {

		final Book book = new Book();
		book.setAuthor("Stephen King");
		book.setPrice(16.99);
		book.setTitle("The Dead Zone");

		final String inputJson = super.mapToJson(book);

		final MvcResult result = mvc.perform(
				MockMvcRequestBuilders.post(RESOURCE_URI).contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();

		final String content = result.getResponse().getContentAsString();
		final int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 201", 201, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value",
				(content != null && !content.isEmpty()));

		final Book createdBook = super.mapFromJson(content, Book.class);

		Assert.assertNotNull("failure - expected Book not null", createdBook);
		Assert.assertNotNull("failure - expected Book.id not null", createdBook.getId());
	}

}
