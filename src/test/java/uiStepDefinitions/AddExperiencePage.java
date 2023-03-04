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
import pojo.Experience;
import utilities.DriverManager;
import utilities.PageManager;
import utilities.Util;

public class AddExperiencePage {

	private WebDriver driver = DriverManager.getInstance();
	private PageManager pages = PageManager.getInstance();

	@When("user enters experience info and submits")
	public void enterExperienceDetails(Experience experience) {
		pages.addExperiencePage().addExperience(experience);
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
