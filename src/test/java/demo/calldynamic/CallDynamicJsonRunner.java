package demo.calldynamic;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/calldynamic/call-dynamic-json.feature")
public class CallDynamicJsonRunner extends TestBase {
    
}
