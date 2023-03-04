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
import utilities.PageManager;

public class DashboardPageSteps {

	private WebDriver driver = DriverManager.getInstance();
	private PageManager pages = PageManager.getInstance();

	@Then("user should be on the dashboard page")
	public void validateDashboard() {
		pages.dashboardPage().validate();
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

}
