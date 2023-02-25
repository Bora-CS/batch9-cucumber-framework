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
import utilities.DriverManager;

public class PostPage {

	private WebDriver driver = DriverManager.getInstance();
	private String postContent;

	@When("user enters some post content and clicks on submit")
	public void createPost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		Random random = new Random();
		int sixDigit = random.nextInt(999999 + 1 - 100000) + 100000;
		postContent = data.get("content") + " - " + sixDigit;
		driver.findElement(By.tagName("textarea")).sendKeys(postContent);
		driver.findElement(By.tagName("input")).click();
	}

	@Then("the newly created post should be on the page")
	public void validatePost() {
		try {
			driver.findElement(By.xpath("//p[text()='" + postContent + "']"));
			assertTrue(true);
		} catch (NoSuchElementException e) {
			assertTrue(false, "There was no post found with the content - " + postContent);
		}
	}

}
