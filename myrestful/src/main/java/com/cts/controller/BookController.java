package com.cts.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Book;

@RestController
public class BookController {
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String addBook(@RequestBody Book b) {
		
		System.out.println(b.getBookId());
		System.out.println(b.getAuthorEmail());
		System.out.println(b.getAuthorName());
		System.out.println(b.getBookName());
		System.out.println(b.getCost());
		return "Success";
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET,
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public Book getBook(@PathVariable("id") Integer id) {
		// make a service call by passing book id and get Book from DB
		Book b = new Book();
		b.setBookId(id);
		b.setBookName("Hadoop");
		b.setCost(900.0);
		b.setAuthorName("Tom White");
		b.setAuthorEmail("tom@javahome.in");
		return b;
	}
	
}