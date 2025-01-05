package com.biblioteca;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.databaseService.AuthorModel;
import com.biblioteca.databaseService.AuthorRepository;
import com.biblioteca.databaseService.BookModel;
import com.biblioteca.databaseService.BookRepository;
import com.biblioteca.serializedService.BookDTO;
import com.biblioteca.serializedService.BookWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataAddedService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    public void addData () throws IOException, InterruptedException{
        var request = new Httprequestcontroller();
        String res = request.sendRequest("https://gutendex.com/books/");



        ObjectMapper mapper = new ObjectMapper();

        //parsear los datos con la clase wrapper que da una lista de books
        BookWrapper datWrapper = mapper.readValue(res, BookWrapper.class);


        for(BookDTO book : datWrapper.getBooks()){


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



        System.out.println("Data added");


    }
}
