package com.test.dao;

import com.test.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAuthor(Author r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
		logger.info("Author saved successfully, Author Details="+r);
	}

	@Override
	public void updateAuthor(Author r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(r);
		logger.info("Author updated successfully, Author Details="+r);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> listAuthors() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Author> authorsList = session.createQuery("from Author").list();
		for(Author r : authorsList){
			logger.info("Author List::"+r);
		}
		return authorsList;
	}

	@Override
	public Author getAuthorById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Author r = (Author) session.load(Author.class, new Integer(id));
		logger.info("Author loaded successfully, Author details="+r);
		return r;
	}

	@Override
	public void removeAuthor(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Author r = (Author) session.load(Author.class, new Integer(id));
		if(null != r){
			session.delete(r);
		}
		logger.info("Author deleted successfully, author details="+r);
	}

}
