package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {

	// Local Variable
	private WebDriver driver;

	// Elements
	@FindBy(how = How.XPATH, using = "//*[@class='alert alert-danger']")
	private WebElement errorAlert;

	@FindBy(how = How.XPATH, using = "//*[@class='alert alert-danger']")
	private List<WebElement> errorAlerts;

	// Constructor
	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validateSingleErrorMessage(String expectedErrorMessage) {
		try {
			String actualErrorMessage = errorAlert.getText();
			assertEquals(expectedErrorMessage.trim(), actualErrorMessage.trim(), "Error message does not match");
		} catch (NoSuchElementException e) {
			assertTrue(false, "Expected an error alert");
		}
	}

}
