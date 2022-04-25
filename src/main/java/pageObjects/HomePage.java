package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		WaitUntilWebElementIsVisible(mostActiveTable);
		
		List<WebElement> listOdd = mostActiveTable.findElements(By.className("odd"));
		List<WebElement> listEven = mostActiveTable.findElements(By.className("even"));
		List<Map<String, String>> listMap = populateMap(listOdd, listEven);
		
		System.out.println("Most Active List: " + listMap);
	}

	private List<Map<String, String>> populateMap(List<WebElement> listOdd, List<WebElement> listEven) {
		List<Map<String, String>> output = new ArrayList();
		extractData(output, listOdd);
		extractData(output, listEven);
		
		return output;
	}

	private void extractData(List<Map<String, String>> output, List<WebElement> list) {
		for (WebElement element : list) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			
			String symbol = element.findElement(By.className("leftcelltd")).getText();
			map.put("symbol", symbol);
			
			List<WebElement> rightElements = element.findElements(By.className("rightcelltd"));
			for (WebElement tableElement : rightElements) {
				if (tableElement.getText().contains("%")) {
					map.put("%Chg", tableElement.getText());
				} else if (tableElement.getText().contains("M") || tableElement.getText().contains("B")) {
					map.put("mktCap", tableElement.getText());
				} else if (tableElement.getText().contains("+") || tableElement.getText().contains("-") || tableElement.getText().equalsIgnoreCase("0.00")) {
					map.put("chg", tableElement.getText());
				} else {
					map.put("price", tableElement.getText());
				}
			}
			
			output.add(map);
		}		
	}

	public void fetchDataFromGainers() {
		// TODO Auto-generated method stub
		
	}

	public void createCSV() {
		// TODO Auto-generated method stub
		
	}

}
