package com.dmi.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.dmi.AbstractControllerTest;

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
    public void testGetBooks() throws Exception {
    	
        final MvcResult result = super.mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URI).accept(MediaType.APPLICATION_JSON)).andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", (content!=null && !content.isEmpty()));
    }
    
    
    @Test
    public void testGetSpecificBook() throws Exception {

        final Long id = new Long(1);

        final MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get(RESOURCE_URI+"/"+id).accept(MediaType.APPLICATION_JSON))
                .andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", (content!=null && !content.isEmpty()));

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
    public void testCreateGreeting() throws Exception {

        final Greeting greeting = new Greeting();
        greeting.setText("test");
        final String inputJson = super.mapToJson(greeting);

        final MvcResult result = mvc.perform(MockMvcRequestBuilders.post(RESOURCE_URI)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        final String content = result.getResponse().getContentAsString();
        final int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 201", 201, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", !Strings.isNullOrEmpty(content));

        final Greeting createdGreeting = super.mapFromJson(content, Greeting.class);

        Assert.assertNotNull("failure - expected greeting not null", createdGreeting);
        Assert.assertNotNull("failure - expected greeting.id not null", createdGreeting.getId());
        Assert.assertEquals("failure - expected greeting.text match", "test", createdGreeting.getText());

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
