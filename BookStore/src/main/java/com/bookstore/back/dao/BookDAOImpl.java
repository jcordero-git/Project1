package com.bookstore.back.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.back.domain.Book;

@SuppressWarnings("unused")
@Transactional
@Repository  ("bookDAO")
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
/*
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	*/
	
	public void insert(Book book) {
		sessionFactory.getCurrentSession().save(book);
		
	}

	public List<Book> find() {
		 return sessionFactory.getCurrentSession().createQuery("from Book")
	                .list();
	}

	public void delete(Integer id) {
		Book book = (Book) sessionFactory.getCurrentSession().load(
                Book.class, id);
        if (null != book) {
            sessionFactory.getCurrentSession().delete(book);
        }

		
	}
	
	public List<Book> getByTitle(String title)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Book where title = :title");
		query.setParameter("title", title);
		return query.list();

	}


}
