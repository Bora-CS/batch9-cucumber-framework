package uiStepDefinitions;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PageManager;
import utilities.Util;

public class PostPageSteps {

	private PageManager pages = PageManager.getInstance();
	private String postContent;

	@When("user enters some post content and clicks on submit")
	public void createPost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		postContent = data.get("content") + " - " + Util.get6DigitCode();
		pages.postPage().createPost(postContent);
	}

	@Then("the newly created post should be on the page")
	public void validatePost() {
		pages.postPage().validatePostByNameAndContent("Muradil Erkin", postContent);
	}

}
