package automation;

import io.cucumber.java.en.*;

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
	}

}
