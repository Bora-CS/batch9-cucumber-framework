package pageObjects;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Util;

public class AddEducationPage {

	private WebDriver driver;

	@FindBy(how = How.NAME, using = "school")
	WebElement schoolField;

	@FindBy(how = How.NAME, using = "degree")
	WebElement degreeField;

	@FindBy(how = How.NAME, using = "fieldofstudy")
	WebElement fieldOfStudyField;

	@FindBy(how = How.NAME, using = "from")
	WebElement fromDate;

	@FindBy(how = How.NAME, using = "current")
	WebElement currentDateCheckBox;

	@FindBy(how = How.NAME, using = "to")
	WebElement toDate;

	@FindBy(how = How.TAG_NAME, using = "textarea")
	WebElement descriptionField;

	@FindBy(how = How.CLASS_NAME, using = "btn-primary")
	WebElement submitButton;

	public AddEducationPage(WebDriver passedDriver) {
		driver = passedDriver;
		PageFactory.initElements(driver, this);
	}

	public void enterEducationInfo(Map<String, String> datas) {

		for (String dataKey : datas.keySet()) {
			switch (dataKey) {
			case "school":
				schoolField.sendKeys(datas.get(dataKey));
				break;
			case "degree":
				degreeField.sendKeys(datas.get(dataKey));
				break;
			case "fieldofstudy":
				fieldOfStudyField.sendKeys(datas.get(dataKey));
				break;
			case "from":
				fromDate.sendKeys(datas.get(dataKey));
				break;
			case "to":
				toDate.sendKeys(datas.get(dataKey));
				break;
			case "current":
				if (datas.get(dataKey).equals("true"))
					currentDateCheckBox.click();
				break;
			case "description":
				descriptionField.sendKeys(datas.get(dataKey));
				break;
			default:
				System.out.println("Something is wrong! passed key: "+dataKey);
			}
			Util.wait(1);
		}
		submitButton.click();

	}
	

	

}
