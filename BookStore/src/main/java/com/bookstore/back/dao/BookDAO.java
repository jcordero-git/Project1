package com.bookstore.back.dao;

import java.util.List;
import com.bookstore.back.domain.Book;

public interface BookDAO {

	public void insert(Book book);

	public List<Book> find();

	public void delete(Integer id);
	
	public List<Book> getByTitle(String title);
}
