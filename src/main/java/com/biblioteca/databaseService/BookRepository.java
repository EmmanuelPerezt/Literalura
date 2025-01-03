package com.biblioteca.databaseService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
    List<BookModel> findByTitle(String title);
    List<BookModel> findByLanguage(String language);
    List<BookModel> findByAuthors(String author);
    List<BookModel> findByTitleAndLanguage(String title, String language);
    List<BookModel> findByTitleAndAuthors(String title, String author);
    List<BookModel> findByLanguageAndAuthors(String language, String author);
    List<BookModel> findByTitleAndLanguageAndAuthors(String title, String language, String author);
    
}
