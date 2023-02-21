package automation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

<<<<<<< HEAD
public class StepDefinitions {

	@Given("user is on the boratech practice site homepage")
	public void user_is_on_the_boratech_practice_site_homepage() {
	   System.out.println("running step -1"); 
	}

	@When("user navigates to the login page")
	public void user_navigates_to_the_login_page() {
		System.out.println("running step -2");   
	}

	@When("user enters username {double} \"shaoling.stouder@gmail.com\"and password {double} {string}")
	public void user_enters_username_shaoling_stouder_gmail_com_and_password(Double double1, Double double2, String string) {
		System.out.println("running step -3");   
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		System.out.println("running step -4");  
	}

	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		System.out.println("running step -5"); 
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import utilities.DriverManager;
import utilities.Util;

public class StepDefinitions {

	private WebDriver driver;

	@Then("user is on the boratech practice site homepage")
	public void navigateToHomePage() throws Exception {
		System.setProperty("webdriver.chrome.driver", DriverManager.getDriverPath());
		driver = new ChromeDriver();
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
		driver.quit();
>>>>>>> 8d5515dac4ebbf7808996bf12f79ed6fc6cdd93b
	}

}
