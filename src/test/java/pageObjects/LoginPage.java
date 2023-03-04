package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://boratech-practice-app.onrender.com/login";

	// Elements
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	private WebElement emailField;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement loginButton;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigate() {
		driver.get(URL);
	}

	public void login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public void enterUserCredentials(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

}
