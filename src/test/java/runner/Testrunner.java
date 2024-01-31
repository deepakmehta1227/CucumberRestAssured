package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/features/GetProduct.feature", 
glue = "stepDefinitions", 
plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} 
 
)

public class Testrunner extends AbstractTestNGCucumberTests {
}