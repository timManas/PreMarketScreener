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

}
