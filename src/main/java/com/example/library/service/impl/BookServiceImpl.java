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

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {

        super(bookRepository);
        this.bookRepository = bookRepository;
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

    @Override
    public Page<Book> findByTitleAndGenre(String title, String genre, Pageable pageable) {
        return bookRepository.findByTitleAndGenre(title, genre, pageable);
    }

    @Override
    public long countBooksByAuthor(Long authorId) {
        return bookRepository.countBooksByAuthor(authorId);
    }
}
