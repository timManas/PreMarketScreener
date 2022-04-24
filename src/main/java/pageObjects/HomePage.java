package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public @FindBy(xpath="//*[@id='most_active_tbl']") WebElement mostActiveTable;

	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void goToPreScreenPage() throws InterruptedException {
		getDriver().get("https://marketchameleon.com/Reports/PremarketTrading");
		Thread.sleep(5000);
	}

	public void fetchDataFromMostActive() throws InterruptedException {
		
		System.out.println(getDriver().getPageSource());

		
		WaitUntilWebElementIsVisible(mostActiveTable);
		System.out.println("MostActiveTable: " + mostActiveTable);
		
		
		
	}

	public void fetchDataFromGainers() {
		// TODO Auto-generated method stub
		
	}

	public void createCSV() {
		// TODO Auto-generated method stub
		
	}

}
