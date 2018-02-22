package com.karate.library.demo.repository;

import com.karate.library.demo.domain.WebSeries;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mandar on 2/21/2018.
 */
public interface WebSeriesRepository extends CrudRepository<WebSeries,Integer> {
}
