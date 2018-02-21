package demo.webseries;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/webseries/webseries.feature")
public class CatsRunner extends TestBase {
    
}
