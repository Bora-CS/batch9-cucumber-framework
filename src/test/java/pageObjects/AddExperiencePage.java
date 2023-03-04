package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pojo.Experience;
import utilities.DriverManager;

public class AddExperiencePage {

	// Local Variable
	private WebDriver driver;

	// Elements
	@FindBy(how = How.NAME, using = "title")
	private WebElement titleField;

	@FindBy(how = How.NAME, using = "company")
	private WebElement companyField;

	@FindBy(how = How.NAME, using = "location")
	private WebElement locationField;

	@FindBy(how = How.NAME, using = "from")
	private WebElement fromDateField;

	@FindBy(how = How.NAME, using = "to")
	private WebElement toDateField;

	@FindBy(how = How.NAME, using = "current")
	private WebElement currentJobCheckbox;

	@FindBy(how = How.XPATH, using = "//textarea[@name='description']")
	private WebElement descriptionField;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement submitButton;

	// Constructor
	public AddExperiencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void addExperience(Experience experience) {
		titleField.sendKeys(experience.title);
		companyField
				.sendKeys(experience.company.isEmpty() ? "" : experience.company + "-" + DriverManager.getSessionId());
		locationField.sendKeys(experience.location);
		fromDateField.sendKeys(experience.from);
		if (experience.current) {
			currentJobCheckbox.click();
		} else {
			toDateField.sendKeys(experience.to);
		}
		descriptionField.sendKeys(experience.description);
		submitButton.click();
	}

}
