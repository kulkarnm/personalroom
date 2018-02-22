package demo.readfeaturejson;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/readfeaturejson/call-json-array.feature")
public class CallJsonArrayRunner extends TestBase {
    
}
