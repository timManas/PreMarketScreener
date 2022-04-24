package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.en.Given;
import pageObjects.BasePage;

public class HomePageSteps extends DriverFactory {

	@Given("^I access prescreen_page$")
	public void i_access_prescreen_page() throws Throwable {
		homePage.goToPreScreenPage();
	}

}
