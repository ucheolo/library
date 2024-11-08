package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BaseService;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseService<Book, Long> implements BookService {

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {

        super(bookRepository);
    }

    @Override
    public Book findBookById(Long id) {
        return findById(id);
    }

    @Override
    public Book createBook(Book book) {
        return save(book);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return ((BookRepository) repository).findAll(pageable);
    }

    @Override
    public void deleteBook(Long id) {
        deleteById(id);
    }
}
