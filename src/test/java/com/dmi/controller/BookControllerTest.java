package com.dmi.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.dmi.AbstractControllerTest;
import com.dmi.domain.Book;

/**
 * <p>
 * Unit tests using Spring MVC Mocks.
 * </p>
 * 
 * @author Robson Martins
 */
@Transactional
public class BookControllerTest extends AbstractControllerTest {
	
	private static final String VERSION = "/v2";
    private static final String RESOURCE_URI = "/api"+VERSION+"/items";

    @Test
    public void testAllBooks() throws Exception {
    	
        final MvcResult result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URI).accept(MediaType.APPLICATION_JSON)).andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", (content!=null && !content.isEmpty()));
    }
    
    
    @Test
    public void testSpecificBook() throws Exception {

        final Long id = new Long(1);

        final MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get(RESOURCE_URI, id).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", (content!=null && !content.isEmpty()));

    }

    @Test
    public void testCreateGreeting() throws Exception {

        final Book book = new Book();
        book.setAuthor("William Cheiquisper");
        book.setImage("http://assignment.gae.golgek.mobi/static/200.jpg");
        book.setPrice(12.55);
        book.setTitle("Hamlet");
        
        final String inputJson = super.mapToJson(book);

        final MvcResult result = mvc.perform(MockMvcRequestBuilders.post(RESOURCE_URI)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 201", 201, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", (content!=null && !content.isEmpty()));

        final Book createdBook = super.mapFromJson(content, Book.class);

        Assert.assertNotNull("failure - expected Book not null", createdBook);
        Assert.assertNotNull("failure - expected Book.id not null", createdBook.getId());
        Assert.assertEquals("failure - expected Book.text match", "test", createdBook.getId());
    }
    
    /*
    @Test
    public void testGetGreetingNotFound() throws Exception {

        final Long id = Long.MAX_VALUE;

        final MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get(RESOURCE_ITEM_URI, id).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 404", 404, status);
        Assert.assertTrue("failure - expected HTTP response body to be empty", Strings.isNullOrEmpty(content));

    }

    @Test
    public void testUpdateGreeting() throws Exception {

        final Long id = new Long(1);
        final Greeting greeting = greetingService.findOne(id);
        final String updatedText = greeting.getText() + " test";

        greeting.setText(updatedText);

        final String inputJson = super.mapToJson(greeting);

        final MvcResult result = mvc.perform(MockMvcRequestBuilders.put(RESOURCE_ITEM_URI, id)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", !Strings.isNullOrEmpty(content));

        final Greeting updatedGreeting = super.mapFromJson(content, Greeting.class);

        Assert.assertNotNull("failure - expected greeting not null", updatedGreeting);
        Assert.assertEquals("failure - expected greeting.id unchanged", greeting.getId(), updatedGreeting.getId());
        Assert.assertEquals("failure - expected updated greeting text match", updatedText, updatedGreeting.getText());

    }

    @Test
    public void testDeleteGreeting() throws Exception {

        final Long id = new Long(1);

        final MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(RESOURCE_ITEM_URI, id)).andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 204", 204, status);
        Assert.assertTrue("failure - expected HTTP response body to be empty", Strings.isNullOrEmpty(content));

        final Greeting deletedGreeting = greetingService.findOne(id);

        Assert.assertNull("failure - expected greeting to be null", deletedGreeting);

    }
*/
}
