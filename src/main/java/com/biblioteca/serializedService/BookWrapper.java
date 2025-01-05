package com.biblioteca.serializedService;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookWrapper {
    @JsonProperty("results")
    private List<BookDTO> books;



    //getter and setter methods
    public List<BookDTO> getBooks() {
        return books;
    }
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }   
}