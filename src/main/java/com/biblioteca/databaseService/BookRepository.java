package com.biblioteca.databaseService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {
    List<BookModel> findByLanguage(String language);
    

    @Query("SELECT b FROM BookModel b WHERE LOWER(b.title) = LOWER(:title)")
    List<BookModel> findByTitleIgnoreCase(String title);

    @Query("SELECT b FROM BookModel b JOIN b.authors a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :author, '%'))")
    List<BookModel> findByAuthorNameIgnoreCase(@Param("author") String author);
    @Query("SELECT b FROM BookModel b WHERE LOWER(b.language) LIKE LOWER(CONCAT('%', :language, '%'))")
    List<BookModel> findByLanguageContainingIgnoreCase(@Param("language") String language);
    
}
