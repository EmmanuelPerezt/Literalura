package com.biblioteca.serializedService;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {
    
    @JsonProperty("id")
    Integer id;
    @JsonProperty("title")
    String title;
    @JsonProperty("languages")
    String languages;
    @JsonProperty("authors")
    List<String> authors= new ArrayList<>();



    public BookDTO(Integer id, String title, String languages, List<String> authors) {
        this.id = id;
        this.title = title;
        this.languages = languages;
        this.authors = authors;
    }
    //getter and setter methods
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLanguages() {
        return languages;
    }
    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    

}
