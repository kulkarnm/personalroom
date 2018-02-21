package demo.error;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/error/error.feature")
public class ErrorRunner extends TestBase {
    
}
