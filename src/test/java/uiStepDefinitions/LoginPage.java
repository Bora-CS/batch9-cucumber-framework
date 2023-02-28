package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;

public class LoginPage {

	private WebDriver driver = DriverManager.getInstance();

	@When("user enters username - {string} and password - {string}")
	public void enterCredentials(String username, String password) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@When("user clicks on the login button")
	public void clickLogin() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@When("user enters username and password")
	public void user_enters_username_and_password(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("password"));
	}

	@Then("user should see error message")
	public void user_should_see_error_message(DataTable dataTable) {
		String expectedErrorMessage = dataTable.asMap().get("error");
		try {
			WebElement errorElement = driver.findElement(By.xpath("//*[@class='alert alert-danger']"));
			String actualErrorMessage = errorElement.getText();
			assertEquals(expectedErrorMessage, actualErrorMessage);
		} catch (NoSuchElementException e) {
			assertTrue(false, "Error alert did not display.");
		}
	}

}
