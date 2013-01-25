package com.bookstore.back.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.back.domain.Author;

@Transactional
@Repository("authorDAO")
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Author author) {

		sessionFactory.getCurrentSession().save(author);

	}

	public List<Author> find() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				"from Author");

		return criteria.list();

	}

	public void delete(Integer id) {
		Author author = (Author) sessionFactory.getCurrentSession().load(
				Author.class, id);
		if (null != author) {
			sessionFactory.getCurrentSession().delete(author);
		}

	}

	public List<Author> getByName(String name)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Author where name = :name");
		query.setParameter("name", name);
		return query.list();

	}

}