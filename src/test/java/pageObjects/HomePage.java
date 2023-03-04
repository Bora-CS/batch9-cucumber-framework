package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://boratech-practice-app.onrender.com/";

	// Elements

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

}
