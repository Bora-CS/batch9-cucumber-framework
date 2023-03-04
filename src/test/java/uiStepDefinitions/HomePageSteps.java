package uiStepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.DriverManager;

public class HomePageSteps {

	private WebDriver driver = DriverManager.getInstance();
	private HomePage homePage = new HomePage(driver);

	@Then("user is on the boratech practice site homepage")
	public void navigateToHomePage() {
		homePage.navigate();
	}

	@When("user navigates to the login page")
	public void navigateToLoginPage() {
		homePage.navigateToLoginPage();
	}

	@When("user navigates to the posts page")
	public void navigateToPostsPage() {
		driver.findElement(By.xpath("//a[@href='/posts']")).click();
	}
}
