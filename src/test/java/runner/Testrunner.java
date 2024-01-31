package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/features/GetProduct.feature", 
glue = "stepDefinitions", 
plugin = {"pretty", "html:target/cucumber-reports"} 
 
)

public class Testrunner extends AbstractTestNGCucumberTests {
}