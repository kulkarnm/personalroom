package demo.read;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/read/read-files.feature")
public class ReadRunner extends TestBase {
    
}
