package uiStepDefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import utilities.DriverManager;

public class AddEducationPage {
	private WebDriver driver = DriverManager.getInstance();

	@When("user enters education info and submits")
	public void user_enters_education_info_and_submits(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		driver.findElement(By.name("school"))
				.sendKeys(data.get("school") == null ? "" : data.get("school") + "-" + DriverManager.getSessionId());
		driver.findElement(By.name("degree")).sendKeys(data.get("degree") == null ? "" : data.get("degree"));
		driver.findElement(By.name("fieldofstudy"))
				.sendKeys(data.get("fieldOfStudy") == null ? "" : data.get("fieldOfStudy"));
		driver.findElement(By.name("from")).sendKeys(data.get("fromDate") == null ? "" : data.get("fromDate"));
		if (data.get("current").equals("true")) {
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		} else {
			driver.findElement(By.name("to")).sendKeys(data.get("toDate") == null ? "" : data.get("toDate"));
		}
		driver.findElement(By.tagName("textarea"))
				.sendKeys(data.get("description") == null ? "" : data.get("description"));
		driver.findElement(By.cssSelector(".btn.btn-primary.my-1")).click();

	}

}
