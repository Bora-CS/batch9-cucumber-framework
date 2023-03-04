package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://boratech-practice-app.onrender.com/login";

	// Elements
	private By emailField = By.xpath("//input[@name='email']");
	private By passwordField = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//input[@value='Login']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public void enterUserCredentials(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}

}
