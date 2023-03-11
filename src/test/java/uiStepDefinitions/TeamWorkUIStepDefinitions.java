package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverManager;
import utilities.PageManager;

public class TeamWorkUIStepDefinitions {
	
	PageManager pages = PageManager.getInstance();
	String userName;
	String content;
	
	/***team 1***/
	@When("user find a specific post and thumbs up")
	public void userFindASpecificPostAndThumbsUp(DataTable dataTable) {
	    
	   Map<String, String> data = dataTable.asMap();
	    userName = data.get("username");
	    content = data.get("content");
	   
	   pages.postPage().thumbsUpForGivenUser(userName, content);
		
	}
	@Then("user should able to see the number {int} in this content")
	public void userShouldAbleToSeeTheNumberInThisContent(int expectingNumber) {
		
		String actualNumber = pages.postPage().getThumbsUpNumberForGivenUser(userName, content);
		assertEquals(expectingNumber+"", actualNumber, "There is something wrong!" );

	}
	@Then("user find a specific post and thumbs down")
	public void userFindASpecificPostAndThumbsDown(DataTable dataTable) {
		   Map<String, String> data = dataTable.asMap();
		    userName = data.get("username");
		    content = data.get("content");
		    
		pages.postPage().thumbsDownForGivenUser(userName, content);
	}
	@Then("user should able to see there is no number in this content")
	public void userShouldAbleToSeeThereIsNoNumberInThisContent() {

		assertFalse(pages.postPage().verifyThumbsUpNumberForGivenUser(userName, content),
				"There is something wrong!");
	}
	
	/***team 2***/
	@Then("user submit a post without content")
	public void userSubmitAPostWithoutContent() {
	   
		throw new io.cucumber.java.PendingException();
	}
	@Then("user should see a alert in the post page {string}")
	public void userShouldSeeAAlertInThePostPage(String string) {
	   
		throw new io.cucumber.java.PendingException();
	}
	
	/***team 3***/
	@Then("user enter education info")
	public void userEnterEducationInfo(DataTable dataTable) {
	   
		throw new io.cucumber.java.PendingException();
	}
	@Then("verify the education info is been added")
	public void verifyTheEducationInfoIsBeenAdded(DataTable dataTable) {
	   
		
		throw new io.cucumber.java.PendingException();
	}
	@Then("delete the duection info")
	public void deleteTheDuectionInfo(DataTable dataTable) {
	   
		
		throw new io.cucumber.java.PendingException();
	}

}
