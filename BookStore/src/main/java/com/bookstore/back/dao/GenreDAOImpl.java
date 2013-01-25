package com.bookstore.back.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.back.domain.Genre;

@Transactional
@Repository("genreDAO")
public class GenreDAOImpl implements GenreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory){
	 * this.sessionFactory = sessionFactory; }
	 */

	public void insert(Genre genre) {
		sessionFactory.getCurrentSession().save(genre);
		// TODO Auto-generated method stub

	}

	public List<Genre> find() {
		return sessionFactory.getCurrentSession().createQuery("from Genre")
				.list();

	}

	public void delete(Integer id) {
		Genre genre = (Genre) sessionFactory.getCurrentSession().load(
				Genre.class, id);
		if (null != genre) {
			sessionFactory.getCurrentSession().delete(genre);
		}

	}

	public List<Genre> getByType(String type) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Genre where type = :type");
		query.setParameter("type", type);
		return query.list();

	}

}