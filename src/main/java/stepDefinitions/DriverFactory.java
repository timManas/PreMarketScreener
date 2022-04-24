package stepDefinitions;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.HomePage;
import utils.Constants;

public class DriverFactory {
	public static WebDriver driver;
	public static HomePage homePage;

	public WebDriver getDriver() {
		try {
			// Read Config
			Properties properties = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//properties//config.properties");
			properties.load(fi);

			String browserName = properties.getProperty("browser");
			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.out.println("Opening Chrome");
					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new ChromeDriver();
					System.out.println("Driver: " + driver);
					driver.manage().window().maximize();
					System.out.println("Chrome Opened");
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_DIRECTORY);
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(capabilities);
					driver.manage().window().maximize();
				}
				break;
				
			case "safari":
				// code
				if (null == driver) {
					System.out.println("Opening Safari");
//					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new SafariDriver();
					System.out.println("Driver: " + driver);
					driver.manage().window().maximize();
					System.out.println("Chrome Opened");
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			homePage = PageFactory.initElements(driver, HomePage.class);
		}
		return driver;
	}

}