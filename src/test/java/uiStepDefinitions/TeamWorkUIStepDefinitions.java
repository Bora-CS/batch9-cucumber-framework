package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
	   
		pages.postPage().clickSubmitButton();
	}
	@Then("user should see a alert in the post page {string}")
	public void userShouldSeeAAlertInThePostPage(String expectingErrorMessage) {
	   String actualErrorMessage = pages.postPage().getErrorMessage();
		assertTrue(actualErrorMessage.equals(expectingErrorMessage), 
				"The message is not match, the actual message display in the UI is: "+actualErrorMessage);
	}
	
	/***team 3***/
	@Then("user enter education info")
	public void userEnterEducationInfo(DataTable dataTable) {
	   
		Map<String,String> datas = dataTable.asMaps().get(0);
		
		pages.addEducationPage().enterEducationInfo(datas);
		
		
		
	}
	@Then("verify the education info is been added")
	public void verifyTheEducationInfoIsBeenAdded(DataTable dataTable) {
	 
		String schoolName = dataTable.asMap().get("school");
		boolean isFound = pages.dashboardPage().verifySchoolIsBeenAdded(schoolName);
		assertTrue(isFound);
		
	}
	@Then("delete the duection info")
	public void deleteTheDuectionInfo(DataTable dataTable) {
		String schoolName = dataTable.asMap().get("school");
		pages.dashboardPage().deleteGivenSchool(schoolName);
	}

}
