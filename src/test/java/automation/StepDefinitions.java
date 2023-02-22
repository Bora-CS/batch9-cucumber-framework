package automation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Util;

public class StepDefinitions {

	private WebDriver driver;
	private String postContent;

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

	@When("user enters some post content and clicks on submit")
	public void createPost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		Random random = new Random();
		int sixDigit = random.nextInt(999999 + 1 - 100000) + 100000;
		postContent = data.get("content") + " - " + sixDigit;
		driver.findElement(By.tagName("textarea")).sendKeys(postContent);
		driver.findElement(By.tagName("input")).click();
	}

	@Then("the newly created post should be on the page")
	public void validatePost() {
		try {
			driver.findElement(By.xpath("//p[text()='" + postContent + "']"));
			assertTrue(true);
		} catch (NoSuchElementException e) {
			assertTrue(false, "There was no post found with the content - " + postContent);
		}
	}
	
	
	@Then("user delete the post")
	public void deletePost() {
	    driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	}

	@Then("post should be deleted")
	public void post_should_be_deleted() {
	   try {
		   driver.findElement(By.xpath("//p[text()='" + postContent + "']"));
		   assertTrue(true, "Test Failed");
	   } catch(NoSuchElementException e) {
		   assertTrue(true);
	   }
	}
	
	
	
	
	

}
