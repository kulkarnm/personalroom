package demo.webseries;

import cucumber.api.CucumberOptions;
import demo.TestBase;


@CucumberOptions(features = "classpath:demo/webseries/webseries-xml.feature")
public class WebSeriesXmlRunner extends TestBase {
    
}
