package demo.callfeature;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/callfeature/call-feature.feature")
public class CallFeatureRunner extends TestBase {
    
}
