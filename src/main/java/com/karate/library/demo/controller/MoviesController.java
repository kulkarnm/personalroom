package com.karate.library.demo.controller;

import com.karate.library.demo.domain.Movie;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MoviesController {

    @Autowired(required = true)
    private JdbcTemplate jdbc;

    private final AtomicInteger counter = new AtomicInteger();
    
    private static final RowMapper<Movie> ROW_MAPPER = (rs, rowNum) -> new Movie(rs.getInt("ID"), rs.getString("NAME"));

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        int id = counter.incrementAndGet();
        movie.setId(id);
        jdbc.update("INSERT INTO MOVIES(ID, NAME) values(?, ?)", movie.getId(), movie.getName());
        return movie;
    }

    @GetMapping
    public Collection<Movie> list() {
        return jdbc.query("SELECT * FROM MOVIES", ROW_MAPPER);
    }
    
    @GetMapping("/{id:.+}")
    public Movie get(@PathVariable int id) {
        return jdbc.queryForObject("SELECT * FROM MOVIES M WHERE M.ID = ?", ROW_MAPPER, id);
    }

}
