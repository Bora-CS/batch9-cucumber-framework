package uiStepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;

public class HomePage {

	private WebDriver driver = DriverManager.getInstance();

	@Then("user is on the boratech practice site homepage")
	public void navigateToHomePage() {
		driver.get("https://boratech-practice-app.onrender.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("user navigates to the login page")
	public void navigateToLoginPage() {
		driver.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();
	}

	@When("user navigates to the posts page")
	public void navigateToPostsPage() {
		driver.findElement(By.xpath("//a[@href='/posts']")).click();
	}
}
