package com.test.dao;

import com.test.model.Author;

import java.util.List;

public interface AuthorDAO {

	public void addAuthor(Author r);
	public void updateAuthor(Author r);
	public List<Author> listAuthors();
	public Author getAuthorById(int id);
	public void removeAuthor(int id);
}
