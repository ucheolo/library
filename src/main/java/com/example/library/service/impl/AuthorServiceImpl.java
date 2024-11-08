package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import com.example.library.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseService<Author, Long> implements AuthorService {

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        super(authorRepository);
    }

    @Override
    public Author findAuthorById(Long id) {
        return findById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        return save(author);
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return ((AuthorRepository)repository).findAll(pageable);
    }

    @Override
    public void deleteAuthor(Long id) {
        deleteById(id);
    }
}
