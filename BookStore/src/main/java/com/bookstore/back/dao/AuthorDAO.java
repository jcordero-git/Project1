package com.bookstore.back.dao;

import java.util.List;

import com.bookstore.back.domain.Author;

public interface AuthorDAO {

	public void insert(Author author);

	public List<Author> find();

	public List<Author> getByName(String name);

	public void delete(Integer id);
	
}
