package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DriverManager;
import utilities.Util;

public class DashboardPage {

	// Local Variable
	private WebDriver driver;
	private static final String URL = "https://boratech-practice-app.onrender.com/dashboard";
	private static final String TITLE = "Dashboard";

	// Elements
	@FindBy(how = How.XPATH, using = "//h1[@class='large text-primary']")
	private WebElement titleText;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Experience')]")
	private WebElement addExperienceButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Education')]")
	private WebElement addEducationButton;

	@FindBy(how = How.XPATH, using = "//h2[text()='Experience Credentials']/following-sibling::table[1]//td[1]")
	private List<WebElement> companyCells;

	// Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validate() {
		Util.wait(3);
		String actualUrl = driver.getCurrentUrl();
		assertEquals(URL, actualUrl);

		String actualTitleText = titleText.getText();
		assertEquals(TITLE, actualTitleText);
	}

	public void navigateToAddExperiencePage() {
		addExperienceButton.click();
	}

	public void navigateToAddEducationPage() {
		addEducationButton.click();
	}

	public void findExperienceByCompanyName(String companyName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(titleText, TITLE));
		String expectedCompanyName = companyName + "-" + DriverManager.getSessionId();
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
