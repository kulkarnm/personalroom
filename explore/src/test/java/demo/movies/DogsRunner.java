package demo.movies;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/movies/movies.feature")
public class DogsRunner extends TestBase {
    
}
