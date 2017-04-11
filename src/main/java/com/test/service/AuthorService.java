package com.test.service;

import com.test.model.Author;

import java.util.List;

public interface AuthorService {

	public void addAuthor(Author p);
	public void updateAuthor(Author p);
	public List<Author> listAuthors();
	public Author getAuthorById(int id);
	public void removeAuthor(int id);
	
}
