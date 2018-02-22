package com.karate.library.demo.repository;

import com.karate.library.demo.domain.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mandar on 2/21/2018.
 */
public interface MovieRepository extends CrudRepository<Movie,Integer> {
}
