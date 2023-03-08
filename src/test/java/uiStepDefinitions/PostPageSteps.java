package uiStepDefinitions;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DataManager;
import utilities.PageManager;
import utilities.Util;

public class PostPageSteps {

	private PageManager pages = PageManager.getInstance();
	private DataManager dataManager = DataManager.getInstance();

	@When("user enters some post content and clicks on submit")
	public void createPost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		String postContent = data.get("content") + " - " + Util.get6DigitCode();
		pages.postPage().createPost(postContent);
		dataManager.setPostContent(postContent);
	}

	@Then("the newly created post should be on the page")
	public void validatePost() {
		pages.postPage().validatePostByNameAndContent("Muradil Erkin", dataManager.getPostContent());
	}

	@Then("user should see a post that they created previously")
	public void user_should_see_a_post_that_they_created_previously() {
		pages.postPage().validatePostByIdAndContent(dataManager.getUser()._id, dataManager.getPostContent());
	}

	@When("user deletes the post that they created previously")
	public void user_deletes_the_post_that_they_created_previously() {
		pages.postPage().deletePostByIdAndContent(dataManager.getUser()._id, dataManager.getPostContent());
	}

}
