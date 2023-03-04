package uiStepDefinitions;

import io.cucumber.java.en.*;
import utilities.PageManager;

public class LoginPageSteps {

	private PageManager pages = PageManager.getInstance();

	@When("user enters username - {string} and password - {string}")
	public void enterCredentials(String username, String password) {
		pages.loginPage().enterUserCredentials(username, password);
	}

	@When("user clicks on the login button")
	public void clickLogin() {
		pages.loginPage().clickOnLoginButton();
	}

	@Then("user should see an error alert with the message - {string}")
	public void validateError(String expectedErrorMessage) {
		pages.commonPage().validateSingleErrorMessage(expectedErrorMessage);
	}

}
