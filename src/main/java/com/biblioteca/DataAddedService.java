package com.biblioteca;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.databaseService.BookRepository;

@Service
public class DataAddedService {
    @Autowired
    private BookRepository bookRepository;







    public void addData () throws IOException, InterruptedException{

        var request = new Httprequestcontroller();
        String res = request.sendRequest("https://gutendex.com/books/");
        


    }
}
