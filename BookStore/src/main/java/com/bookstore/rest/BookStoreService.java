package com.bookstore.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bookstore.back.domain.Book;
import com.bookstore.back.interceptor.LogInterceptor;
import com.bookstore.back.service.BookService;

@Path("/service")
@Component("bookStoreService")
public class BookStoreService {

	BookService bookService;
	private static final Logger logger = Logger.getLogger(LogInterceptor.class);

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Book> getBookInXML(@Context ServletContext servletContext) {
		// public List<Book> getBookInXML() {
		// get Spring application context

		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		bookService = ctx.getBean("bookService", BookService.class);
		String toStr = "Prueba";
		List<Book> tempBookList = new ArrayList<Book>();
		tempBookList = bookService.getALL();

		for (Book book : tempBookList) {

			toStr = toStr.concat(book.toString());
		}

		logger.info(toStr);

		return bookService.getALL();

	}

	@GET
	@Path("/redirect")
	@Produces("application/json")
	public String redirect(@Context ServletContext servletContext) {
		// public List<Book> getBookInXML() {
		// get Spring application context

		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);

		return "redirect:/book/list";

	}

	@POST
	@Path("/insert")
	@Consumes("application/json")
	public Response insertBook(Book book, @Context ServletContext servletContext) {

		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		bookService = ctx.getBean("bookService", BookService.class);
		bookService.insert(book);
		return Response.ok("").build();

	}

	@POST
	@Path("/testService")
	public Response testQuery(@QueryParam("parentKey") String parentkey) {

		return Response.status(200).entity("ok, parentKey: " + parentkey).build();

	}

}