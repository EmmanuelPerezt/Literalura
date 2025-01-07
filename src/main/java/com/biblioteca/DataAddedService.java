package com.biblioteca;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.databaseService.AuthorModel;
import com.biblioteca.databaseService.AuthorRepository;
import com.biblioteca.databaseService.BookModel;
import com.biblioteca.databaseService.BookRepository;
import com.biblioteca.serializedService.BookDTO;
import com.biblioteca.serializedService.BookWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

@Service
public class DataAddedService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    // constructor para inyectar las dependencias
    public DataAddedService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void addData() throws IOException, InterruptedException {
        var request = new Httprequestcontroller();
        String res = request.sendRequest("https://gutendex.com/books/");

        ObjectMapper mapper = new ObjectMapper();

        // parsear los datos con la clase wrapper que da una lista de books
        BookWrapper datWrapper = mapper.readValue(res, BookWrapper.class);

        for (BookDTO book : datWrapper.getBooks()) {

            BookModel bookModel = new BookModel();

            bookModel.setId(book.getId());
            bookModel.setTitle(book.getTitle());
            bookModel.setLanguage((String.join(",", book.getLanguages())));

            List<AuthorModel> authors = book.getAuthors().stream()
                    .map(AuthorDTO -> {
                        AuthorModel author = new AuthorModel();
                        author.setName(AuthorDTO.getName());
                        return authorRepository.save(author);
                    }).collect(Collectors.toList());
            bookModel.setAuthors(authors);
            bookRepository.save(bookModel);

        }
        System.out.println("Libros agregados");
    }

    @Transactional
    public void findbyTitle(String title) {
        List<BookModel> books = bookRepository.findByTitleIgnoreCase(title);
        if (!books.isEmpty()) {
            books.forEach(book -> Hibernate.initialize(book.getAuthors()));

            System.out.println("Libros encontrados: ");
            books.forEach(book -> {
                System.out.println("Id: " + book.getId() + "\n");
                System.out.println("Titulo: " + book.getTitle() + "\n");
                System.out.println("Lenguaje: " + book.getLanguage() + "\n");
                System.out.println("Autores: ");
                book.getAuthors().forEach(author -> {
                    System.out.println("Nombre: " + author.getName());
                });
            });
        } else {
            System.out.println("No se encontraron libros con ese titulo");

        }
    }

    @Transactional
    public void findByauthor(String author) {
        List<BookModel> books = bookRepository.findByAuthorNameIgnoreCase(author);
        if (!books.isEmpty()) {
            books.forEach(book -> Hibernate.initialize(book.getAuthors()));

            System.out.println("Libros encontrados: ");
            books.forEach(book -> {
                System.out.println("Id: " + book.getId() + "\n");
                System.out.println("Titulo: " + book.getTitle() + "\n");
                System.out.println("Lenguaje: " + book.getLanguage() + "\n");
                System.out.println("Autores: ");
                book.getAuthors().forEach(authors -> {
                    System.out.println("Nombre: " + authors.getName());
                });
            });
        } else {
            System.out.println("No se encontraron libros con ese autor");

        }
    }
    @Transactional
    public void findBylanguage(String language) {
        List<BookModel> books = bookRepository.findByLanguageContainingIgnoreCase(language);
        if (!books.isEmpty()) {
            books.forEach(book -> Hibernate.initialize(book.getAuthors()));

            System.out.println("Libros encontrados: ");
            books.forEach(book -> {
                System.out.println("Id: " + book.getId() + "\n");
                System.out.println("Titulo: " + book.getTitle() + "\n");
                System.out.println("Lenguaje: " + book.getLanguage() + "\n");
                System.out.println("Autores: ");
                book.getAuthors().forEach(authors -> {
                    System.out.println("Nombre: " + authors.getName());
                });
            });
        } else {
            System.out.println("No se encontraron libros con ese lenguaje");

        }
    }
    public void deleteAll() {
        bookRepository.deleteAll();
        System.out.println("Base de datos eliminada");
    }
}
