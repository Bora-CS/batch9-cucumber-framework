package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Util;

public class DashboardPage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://boratech-practice-app.onrender.com/dashboard";
	private static final String TITLE = "Dashboard";

	// Elements
	private By titleText = By.xpath("//h1[@class='large text-primary']");

	// Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void validate() {
		Util.wait(3);
		String actualUrl = driver.getCurrentUrl();
		assertEquals(URL, actualUrl);

		String actualTitleText = driver.findElement(titleText).getText();
		assertEquals(TITLE, actualTitleText);
	}

}
