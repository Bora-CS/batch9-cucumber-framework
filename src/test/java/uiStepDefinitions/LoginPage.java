package uiStepDefinitions;

import java.time.Duration;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;

public class LoginPage {

	private WebDriver driver = DriverManager.getInstance();
	private String inputEmail;
	private String inputPassword;
	private String actualErrorMessage;

	@When("user enters username and password")
	public void enterCredentials(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		driver.findElement(By.xpath("//input[@name='email']"))
				.sendKeys(data.get("username") == null ? "" : data.get("username"));
		driver.findElement(By.xpath("//input[@name='password']"))
				.sendKeys(data.get("password") == null ? "" : data.get("password"));
		inputEmail=data.get("username");
		inputPassword=data.get("password");
	}

	@When("user clicks on the login button")
	public void clickLogin() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("user should see errors message displayed")
	public void user_should_see_errors_message_displayed(DataTable dataTable) {
		String expectedErrorMessage = dataTable.asMap().get("error");
		try {
			if(inputEmail==null) {
				actualErrorMessage=driver.findElement(By.name("email")).getAttribute("validationMessage");
			}else if(inputPassword==null) {
				actualErrorMessage=driver.findElement(By.name("password")).getAttribute("validationMessage");
			}else{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-danger']")));
			actualErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			}
			assertEquals(expectedErrorMessage, actualErrorMessage);
		} catch (NoSuchElementException e) {
			assertTrue(false, "Error alert did not display.");
		}

	}
}
