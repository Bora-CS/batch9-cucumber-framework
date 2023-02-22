package automation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Util;

public class StepDefinitions {

	private WebDriver driver;
	private String target;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", DriverManager.getDriverPath());
		driver = new ChromeDriver();
	}

	@After
	public void cleanUp() {
		driver.quit();
	}

	@Then("user is on the boratech practice site homepage")
	public void navigateToHomePage() {
		driver.get("https://boratech-practice-app.onrender.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("user navigates to the login page")
	public void navigateToLoginPage() {
		driver.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();
	}

	@When("user enters username - {string} and password - {string}")
	public void enterCredentials(String username, String password) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@When("user clicks on the login button")
	public void clickLogin() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

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

	@When("user navigates to the posts page")
	public void navigateToPostsPage() {
		driver.findElement(By.xpath("//a[@href='/posts']")).click();
	}

	@When("delete the post according to post content")
	public void deletePost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		target = data.get("content");
		
		//solution 1
		driver.findElement(By.xpath("//p[text()='"+target+"']/following-sibling::button[3]")).click();
		
		//solution 2
		/*
		List<WebElement> posts = driver.findElements(By.xpath("//div[@class='posts']/div"));
		for (int index = 1; index <= posts.size(); index++) {
			String wholePostXpath = "//div[@class='posts']/div[" + index + "]";
			String messageXpath = wholePostXpath + "//p[1]";
			String deleteXpath = wholePostXpath + "//button[3]";
			String deleteMessage = driver.findElement(By.xpath(messageXpath)).getText();
			if (deleteMessage.equals(target)) {
				driver.findElement(By.xpath(deleteXpath)).click();
				break;
			}
		}
		*/
	}

	@Then("verify user delete the post successfully")
	public void validation() {
		Util.wait(3);
		List<WebElement> postMessage = driver.findElements(By.xpath("//div[@class='posts']//p[1]"));
		for(WebElement m : postMessage) {
			assertFalse(m.getText().contains(target));
		}
	}

}
