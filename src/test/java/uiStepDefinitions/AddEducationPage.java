package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;
import utilities.Util;

public class AddEducationPage {
	
	private WebDriver driver = DriverManager.getInstance();

	@When("user enters education info and submits")
	public void enterEducationDetails(DataTable dataTable) {
	   Map<String,String> data = dataTable.asMap();
	   driver.findElement(By.name("school")).sendKeys(data.get("school")==null? "" : data.get("school") + "-" + DriverManager.getSessionId());
	   driver.findElement(By.name("degree")).sendKeys(data.get("degree")==null? "" : data.get("degree"));
	   driver.findElement(By.name("fieldofstudy")).sendKeys(data.get("fieldOfStudy")==null? "" : data.get("fieldOfStudy"));
	   driver.findElement(By.name("from")).sendKeys(data.get("fromDate")==null? "" : data.get("fromDate"));
	   if (data.get("current") != null && Boolean.valueOf(data.get("current"))) {
			driver.findElement(By.name("current")).click();
		} else {
			driver.findElement(By.name("to")).sendKeys(data.get("toDate") == null ? "" : data.get("toDate"));
		}
	   driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(data.get("description")==null? "" : data.get("description"));
	   driver.findElement(By.xpath("//input[@type='submit']")).click();
	   Util.wait(6);
	}

	@Then("user should see error message\\(s) on the add education page")
	public void validateErrorMessage(DataTable dataTable) {
		String expectedErrorMsg = dataTable.asMap().get("error");
		try {
			WebElement errorEle = driver.findElement(By.className("alert alert-danger"));
			String actualErrorMsg = errorEle.getText();
			assertEquals(expectedErrorMsg, actualErrorMsg);
		} catch (NoSuchElementException e) {
			assertFalse(false, "Error message is not displayed");
		}
	}
}
