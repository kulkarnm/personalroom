package com.karate.library.demo.controller;

import com.karate.library.demo.domain.WebSeries;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webseries")
public class WebSeriesController {
    
    private final AtomicInteger counter = new AtomicInteger();
    private final Map<Integer, WebSeries> episodes = new ConcurrentHashMap<>();
    
    @PostMapping
    public WebSeries create(@RequestBody WebSeries webSeries) {
        int id = counter.incrementAndGet();
        webSeries.setId(id);
        episodes.put(id, webSeries);
        return webSeries;
    }
    
    @GetMapping
    public Collection<WebSeries> list() {
        return episodes.values();
    }
    
    @GetMapping("/{id:.+}")
    public WebSeries get(@PathVariable int id) {
        return episodes.get(id);
    }
    
    @GetMapping("/{id:.+}/episodes")
    public Collection<WebSeries> getEpisodes(@PathVariable int id) {
        return episodes.get(id).getEpisodes();
    } 
    
    @DeleteMapping("/{id:.+}")
    public void delete(@PathVariable int id) {        
        WebSeries webSeries = episodes.remove(id);
        if (webSeries == null) {
            throw new RuntimeException("webSeries not found, id: " + id);
        }
    }

    @DeleteMapping
    public void deleteWithBody(@RequestBody WebSeries webSeries) {
        int id = webSeries.getId();
        delete(id);
    }    
    
}
