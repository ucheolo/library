package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Book findBookById(Long id);
    Book createBook(Book book);
    Page<Book> findAll(Pageable pageable);
    void deleteBook(Long id);
}
