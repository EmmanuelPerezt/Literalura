package com.biblioteca.databaseService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {
    
}
