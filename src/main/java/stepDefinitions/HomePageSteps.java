package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.BasePage;

public class HomePageSteps extends DriverFactory {

	@Given("^I access prescreen_page$")
	public void i_access_prescreen_page() throws Throwable {
		homePage.goToPreScreenPage();
	}
	
	@Then("^I fetch all data from Most Active$")
	public void i_fetch_all_data_from_Most_Active() throws Throwable {
		homePage.fetchDataFromMostActive();
	}

	@Then("^I fetch all data from Gainers$")
	public void i_fetch_all_data_from_Gainers() throws Throwable {
		homePage.fetchDataFromGainers();
	}

	@Then("^I fetch all data from Decliners$")
	public void i_fetch_all_data_from_Decliners() throws Throwable {
		homePage.fetchDataFromGainers();
	}

	@Then("^I put them all into a csv file$")
	public void i_put_them_all_into_a_csv_file() throws Throwable {
		homePage.createCSV();
	}

}
