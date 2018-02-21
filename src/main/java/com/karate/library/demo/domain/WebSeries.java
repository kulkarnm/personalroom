package com.karate.library.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Document(collection = "WebSeriesView")
public class WebSeries {
    @Id
    private int id;
    private String name;
    private List<WebSeries> episodes;
    
    public void addEpisode(WebSeries kitten) {
        if (episodes == null) {
            episodes = new ArrayList<>();
        }
        episodes.add(kitten);
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

    public List<WebSeries> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<WebSeries> episodes) {
        this.episodes = episodes;
    }        
    
}
