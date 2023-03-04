package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.DriverManager;

public class LoginPageSteps {

	private WebDriver driver = DriverManager.getInstance();
	private LoginPage loginPage = new LoginPage(driver);

	@When("user enters username - {string} and password - {string}")
	public void enterCredentials(String username, String password) {
		loginPage.enterUserCredentials(username, password);
	}

	@When("user clicks on the login button")
	public void clickLogin() {
		loginPage.clickOnLoginButton();
	}

	@Then("user should see an error alert with the message - {string}")
	public void validateError(String expectedErrorMessage) {
		try {
			WebElement errorElement = driver.findElement(By.xpath("//*[@class='alert alert-danger']"));
			String actualErrorMessage = errorElement.getText();
			assertEquals(expectedErrorMessage.trim(), actualErrorMessage.trim(), "Error message does not match");
		} catch (NoSuchElementException e) {
			assertTrue(false, "Expected an error alert");
		}
	}

}
