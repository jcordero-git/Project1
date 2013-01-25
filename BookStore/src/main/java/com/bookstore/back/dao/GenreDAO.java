package com.bookstore.back.dao;

import java.util.List;
import com.bookstore.back.domain.Genre;

public interface GenreDAO {

	public void insert(Genre genre);

	public List<Genre> find();

	public void delete(Integer id);

	public List<Genre> getByType(String type);
}