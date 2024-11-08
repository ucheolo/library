package com.example.library.service;

import com.example.library.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    Author findAuthorById(Long id);
    Author createAuthor(Author author);
    Page<Author> findAll(Pageable pageable);
    void deleteAuthor(Long id);
}
