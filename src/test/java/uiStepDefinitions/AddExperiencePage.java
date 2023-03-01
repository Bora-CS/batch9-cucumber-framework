package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		ArrayList<String> expectedErrors = new ArrayList<>();
		ArrayList<String> actualErrors = new ArrayList<>();

		String combinedErrorMessage = dataTable.asMap().get("error");
		String[] expectedErrorMessages = combinedErrorMessage.split(",");
		for (String message : expectedErrorMessages) {
			expectedErrors.add(message.trim());
		}

		try {
			List<WebElement> errorElements = driver.findElements(By.xpath("//*[@class='alert alert-danger']"));
			for (WebElement errorElement : errorElements) {
				actualErrors.add(errorElement.getText().trim());
			}

			System.out.println("Expected Errors: " + expectedErrors);
			System.out.println("Actual Errors: " + actualErrors);

			Collections.sort(expectedErrors);
			Collections.sort(actualErrors);

			int expectedNumberOfErrors = expectedErrors.size();
			int actualNumberOfErrors = actualErrors.size();

			assertEquals(expectedNumberOfErrors, actualNumberOfErrors, "Number of errors does not match");

			for (int i = 0; i < expectedNumberOfErrors; i++) {
				String expected = expectedErrors.get(i);
				String actual = actualErrors.get(i);

				assertEquals(expected, actual);
			}

		} catch (NoSuchElementException e) {
			assertTrue(false, "Error alert did not display.");
		}
	}

}
