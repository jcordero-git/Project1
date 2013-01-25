package com.bookstore.back.service;

import java.util.Date;
import java.util.List;

import com.bookstore.back.domain.Book;

public interface BookService {

	public List<Book> getALL();

	public List<Book> getByAuthor(String name);

	public List<Book> getByTitle(String title);

	public List<Book> getByCountryISO(String countryISO);

	public List<Book> getByType(String type);

	public List<Book> getByYear(Date year);

	public void insert(Book book);

	public void delete(Integer id);
}