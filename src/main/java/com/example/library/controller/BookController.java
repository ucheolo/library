package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    /// @Service 어노테이션 덕분에 BookServiceImpl이 BookService 타입의 빈으로 등록되고,
    /// 이를 통해 BookService 인터페이스를 사용하는 곳에
    /// BookServiceImpl 구현체가 자동으로 주입됩니다.
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createBook = bookService.createBook(book);
        return new ResponseEntity<>(createBook, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Book> books = bookService.findAll(PageRequest.of(page, size));
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        // book.setId(id);
        Book updateBook = bookService.createBook(book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Book>> searchBooksByTitleAndGenre(
            @RequestParam String title,
            @RequestParam String genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Book> books = bookService.findByTitleAndGenre(title, genre, PageRequest.of(page, size));
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/author/{authorId}/count")
    public ResponseEntity<Long> countBooksByAuthor(@PathVariable Long authorId) {
        long count = bookService.countBooksByAuthor(authorId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
