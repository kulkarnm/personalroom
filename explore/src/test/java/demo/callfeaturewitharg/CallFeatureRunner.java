package demo.callfeaturewitharg;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/callfeaturewitharg/call-feature.feature")
public class CallFeatureRunner extends TestBase {
    
}
