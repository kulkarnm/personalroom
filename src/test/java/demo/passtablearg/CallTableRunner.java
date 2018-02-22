package demo.passtablearg;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/passtablearg/call-table.feature")
public class CallTableRunner extends TestBase {
    
}
