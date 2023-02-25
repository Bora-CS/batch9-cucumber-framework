package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Util;

public class AddExperiencePage {

	private WebDriver driver = DriverManager.getInstance();

	@When("user enters experience info and submits")
	public void enterExperienceDetails(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		driver.findElement(By.name("title")).sendKeys(data.get("jobTitle") == null ? "" : data.get("jobTitle"));
		driver.findElement(By.name("company"))
				.sendKeys(data.get("company") == null ? "" : data.get("company") + "-" + DriverManager.getSessionId());
		driver.findElement(By.name("location")).sendKeys(data.get("location") == null ? "" : data.get("location"));
		driver.findElement(By.name("from")).sendKeys(data.get("fromDate") == null ? "" : data.get("fromDate"));
		if (data.get("current") != null && Boolean.valueOf(data.get("current"))) {
			driver.findElement(By.name("current")).click();
		} else {
			driver.findElement(By.name("to")).sendKeys(data.get("toDate") == null ? "" : data.get("toDate"));
		}
		driver.findElement(By.xpath("//textarea[@name='description']"))
				.sendKeys(data.get("description") == null ? "" : data.get("description"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("user should see error message\\(s)")
	public void validateErrorMessage(DataTable dataTable) {
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
