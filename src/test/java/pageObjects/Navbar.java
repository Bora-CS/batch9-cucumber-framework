package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navbar {

	// Local Variable
	private WebDriver driver;

	// Elements
	private By loginLink = By.xpath("//a[@href='/login']");
	private By postsLink = By.xpath("//a[@href='/posts']");

	// Constructor
	public Navbar(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void navigateToPostPage() {
		driver.findElement(postsLink).click();
	}

	public void navigateToLoginPage() {
		driver.findElement(loginLink).click();
	}

}
