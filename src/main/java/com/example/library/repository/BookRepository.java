package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // 제목 및 장르로 도서 검색
    Page<Book> findByTitleAndGenre(String title, String genre, Pageable pageable);

    // 저자별 도서 수 계산
    @Query("SELECT COUNT(b) FROM Book b WHERE b.author.id = :authorId")
    long countBooksByAuthor(Long authorId);
}
