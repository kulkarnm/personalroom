package demo.webseries;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/webseries/episodes.feature")
public class KittensRunner extends TestBase {
    
}
