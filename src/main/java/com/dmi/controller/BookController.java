package com.dmi.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmi.domain.Book;
import com.dmi.repository.BookRepository;

@Controller
@RequestMapping("/api")
public class BookController extends DMIController{

//    @Autowired
//    private BookService bookService;
    
    @Autowired
    private BookRepository bookRepository;
    

    @RequestMapping(value = "/v1/items", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Book> getBookUrlV1() {
        return bookRepository.findAll();
    }
	
}
