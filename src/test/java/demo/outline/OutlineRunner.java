package demo.outline;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/outline/examples.feature")
public class OutlineRunner extends TestBase {
    
}
