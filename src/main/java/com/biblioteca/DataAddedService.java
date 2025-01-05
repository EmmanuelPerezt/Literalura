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
        bookRepository.deleteAll();
        var request = new Httprequestcontroller();
        String res = request.sendRequest("https://gutendex.com/books/");
        //iterar sobre el json con jackson al res
        //guardar en la base de datos




    }
}
