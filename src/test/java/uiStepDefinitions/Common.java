package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import utilities.DriverManager;
import utilities.Util;

public class Common {

	private WebDriver driver = DriverManager.getInstance();

	@Given("user is logged in")
	public void login(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		driver.get("https://boratech-practice-app.onrender.com/login");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Util.wait(3);
		String expectedUrl = "https://boratech-practice-app.onrender.com/dashboard";
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expectedUrl, actualUrl);
		String expectedTitleText = "Dashboard";
		String actualTitleText = driver.findElement(By.xpath("//h1[@class='large text-primary']")).getText();
		assertEquals(expectedTitleText, actualTitleText);
	}

}
