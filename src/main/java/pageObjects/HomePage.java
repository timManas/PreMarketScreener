package pageObjects;

import java.io.IOException;

public class HomePage extends BasePage {

	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void goToPreScreenPage() {
		// TODO Auto-generated method stub
		getDriver().get("https://marketchameleon.com/Reports/PremarketTrading");
	}

	public void fetchDataFromMostActive() {
		// TODO Auto-generated method stub
		
	}

	public void fetchDataFromGainers() {
		// TODO Auto-generated method stub
		
	}

	public void createCSV() {
		// TODO Auto-generated method stub
		
	}

}
