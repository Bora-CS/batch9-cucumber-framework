package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Navbar {

	// Local Variable
	private WebDriver driver;

	// Elements
	@FindBy(how = How.XPATH, using = "//a[@href='/login']")
	private WebElement loginLink;
	@FindBy(how = How.XPATH, using = "//a[@href='/posts']")
	private WebElement postsLink;

	// Constructor
	public Navbar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigateToPostPage() {
		postsLink.click();
	}

	public void navigateToLoginPage() {
		loginLink.click();
	}

}
