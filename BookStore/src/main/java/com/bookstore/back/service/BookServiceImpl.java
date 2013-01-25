package com.bookstore.back.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.back.dao.AuthorDAO;
import com.bookstore.back.dao.BookDAO;
import com.bookstore.back.dao.GenreDAO;
import com.bookstore.back.domain.Book;

//import com.bookstore.back.domain.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	@Autowired
	private AuthorDAO authorDAO;
	@Autowired
	private GenreDAO genreDAO;

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

	public void setGenreDAO(GenreDAO genreDAO) {
		this.genreDAO = genreDAO;
	}

	public List<Book> getALL() {

		return bookDAO.find();
	}

	public List<Book> getByAuthor(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> getByTitle(String title) {
		// TODO Auto-generated method stub

		List<Book> bookList = bookDAO.find();
		List<Book> bookListReturn = new ArrayList<Book>();
		for (int i = 0; i < bookList.size(); i++) {
			if (title == bookList.get(i).getTitle()) {
				bookListReturn.add(bookList.get(i));
			}

		}

		return bookListReturn;
	}

	public List<Book> getByCountryISO(String countryISO) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> getByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> getByYear(Date year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void insert(Book book) {
		bookDAO.insert(book);

		// TODO Auto-generated method stub

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}