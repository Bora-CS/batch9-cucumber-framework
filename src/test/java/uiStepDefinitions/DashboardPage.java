package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Util;

public class DashboardPage {

	private WebDriver driver = DriverManager.getInstance();

	@Then("user should be on the dashboard page")
	public void validateDashboard() {
		Util.wait(3);
		String expectedUrl = "https://boratech-practice-app.onrender.com/dashboard";
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expectedUrl, actualUrl);
		String expectedTitleText = "Dashboard";
		String actualTitleText = driver.findElement(By.xpath("//h1[@class='large text-primary']")).getText();
		assertEquals(expectedTitleText, actualTitleText);
	}

	@When("user clicks on the add experience button")
	public void addExperience() {
		driver.findElement(By.xpath("//a[contains(text(), 'Add Experience')]")).click();
	}

	@When("user clicks on the add education button")
	public void addEducation() {
		driver.findElement(By.xpath("//a[contains(text(), 'Add Education')]")).click();
	}

	@Then("the experience with the given company name should be displayed")
	public void findExperienceByCompanyName(DataTable dataTable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
		String expectedCompanyName = dataTable.asMap().get("company") + "-" + DriverManager.getSessionId();
		List<WebElement> companyCells = driver
				.findElements(By.xpath("//h2[text()='Experience Credentials']/following-sibling::table[1]//td[1]"));
		boolean found = false;
		for (WebElement companyCell : companyCells) {
			String actualCompanyName = companyCell.getText();
			if (actualCompanyName.equals(expectedCompanyName)) {
				found = true;
				break;
			}
		}
		assertTrue(found, "Company with the name [" + expectedCompanyName + "] is not found.");
	}

	@Then("the education with the given school name should be displayed")
	public void findEducationBySchoolName(DataTable dataTable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
		String expectedSchoolName = dataTable.asMap().get("school") + "-" + DriverManager.getSessionId();
		List<WebElement> schoolCells = driver
				.findElements(By.xpath("//h2[text()='Education Credentials']/following-sibling::table//td[1]"));
		boolean found = false;
		for (WebElement schoolCell : schoolCells) {
			String actualSchoolName = schoolCell.getText();
			if (actualSchoolName.equals(expectedSchoolName)) {
				found = true;
				break;
			}
		}
		assertTrue(found, "Company with the name [" + expectedSchoolName + "] is not found.");
	}
}
