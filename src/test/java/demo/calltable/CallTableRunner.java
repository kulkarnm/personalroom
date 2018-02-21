package demo.calltable;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/calltable/call-table.feature")
public class CallTableRunner extends TestBase {
    
}
