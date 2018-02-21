
package com.karate.library.demo.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MovieView")
public class Movie {
    @Id
    private int id;
    private String name;
    
    public Movie() {
        // zero arg constructor
    }
    
    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        
    
}
