package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//    features = "src/test/resources/features",
    		features = "src/test/resources/features/flipkart_search.feature",
    glue = {"stepDefinitions", "hooks"},
    plugin = {"pretty", "html:target/report.html"},
    monochrome = true
)
public class TestRunner {
}