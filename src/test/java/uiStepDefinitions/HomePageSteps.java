package uiStepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.PageManager;

public class HomePageSteps {

	private PageManager pages = PageManager.getInstance();

	@Then("user is on the boratech practice site homepage")
	public void navigateToHomePage() {
		pages.homePage().navigate();
	}

	@When("user navigates to the login page")
	public void navigateToLoginPage() {
		pages.navbar().navigateToLoginPage();
	}

	@When("user navigates to the posts page")
	public void navigateToPostsPage() {
		pages.navbar().navigateToPostPage();
	}
}
