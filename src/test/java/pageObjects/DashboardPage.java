package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Util;

public class DashboardPage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://boratech-practice-app.onrender.com/dashboard";
	private static final String TITLE = "Dashboard";

	// Elements
	@FindBy(how = How.XPATH, using = "//h1[@class='large text-primary']")
	private WebElement titleText;

	// Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validate() {
		Util.wait(3);
		String actualUrl = driver.getCurrentUrl();
		assertEquals(URL, actualUrl);

		String actualTitleText = titleText.getText();
		assertEquals(TITLE, actualTitleText);
	}

}
