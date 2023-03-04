package uiStepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.Navbar;
import utilities.DriverManager;

public class HomePageSteps {

	private WebDriver driver = DriverManager.getInstance();
	private HomePage homePage = new HomePage(driver);
	private Navbar navbar = new Navbar(driver);

	@Then("user is on the boratech practice site homepage")
	public void navigateToHomePage() {
		homePage.navigate();
	}

	@When("user navigates to the login page")
	public void navigateToLoginPage() {
		navbar.navigateToLoginPage();
	}

	@When("user navigates to the posts page")
	public void navigateToPostsPage() {
		navbar.navigateToPostPage();
	}
}
