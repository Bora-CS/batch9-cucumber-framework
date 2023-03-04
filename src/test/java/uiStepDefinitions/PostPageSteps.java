package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PostPage;
import utilities.DriverManager;
import utilities.Util;

public class PostPageSteps {

	private WebDriver driver = DriverManager.getInstance();
	private PostPage postPage = new PostPage(driver);
	private String postContent;

	@When("user enters some post content and clicks on submit")
	public void createPost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		postContent = data.get("content") + " - " + Util.get6DigitCode();
		postPage.createPost(postContent);
	}

	@Then("the newly created post should be on the page")
	public void validatePost() {
		postPage.validatePostByNameAndContent("Muradil Erkin", postContent);
	}

}
