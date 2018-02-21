package demo.webseries;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Karate.class)
@CucumberOptions(features = "classpath:demo/webseries/syntax-demo.feature")
public class SyntaxRunner {
    
}
