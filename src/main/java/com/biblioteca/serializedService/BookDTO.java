package com.biblioteca.serializedService;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    
    @JsonProperty("id")
    Integer id;
    @JsonProperty("title")
    String title;
    @JsonProperty("languages")
    List<String> languages;
    @JsonProperty("authors")
    List<AuthorDTO> authors= new ArrayList<>();


    public BookDTO() {
    }


    public BookDTO(Integer id, String title, List<String> languages, List<AuthorDTO> authors) {
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
    public List<String> getLanguages() {
        return languages;
    }
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
    public List<AuthorDTO> getAuthors() {
        return authors;
    }
    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }
    

}
