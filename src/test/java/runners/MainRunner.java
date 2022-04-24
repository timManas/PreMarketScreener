package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = { "src/test/java/resources/features/home.feature" }, 
		glue = {"stepDefinitions" }, 
		monochrome = true, 
		tags = {}, 
		plugin = { 	"pretty", 
					"html:target/cucumber", 
					"json:target/cucumber.json",
					"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })


public class MainRunner extends AbstractTestNGCucumberTests {
}
