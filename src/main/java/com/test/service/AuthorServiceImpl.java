package com.test.service;

import java.util.List;

import com.test.dao.AuthorDAO;
import com.test.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDAO;

	@Override
	@Transactional
	public void addAuthor(Author p) {
		this.authorDAO.addAuthor(p);
	}

	@Override
	@Transactional
	public void updateAuthor(Author p) {
		this.authorDAO.updateAuthor(p);
	}

	@Override
	@Transactional
	public List<Author> listAuthors() {
		return this.authorDAO.listAuthors();
	}

	@Override
	@Transactional
	public Author getAuthorById(int id) {
		return this.authorDAO.getAuthorById(id);
	}

	@Override
	@Transactional
	public void removeAuthor(int id) {
		this.authorDAO.removeAuthor(id);
	}

}
