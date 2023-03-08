package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.Util;

public class PostPage {

	// Local Variable
	private WebDriver driver;

	// Elements
	@FindBy(how = How.XPATH, using = "//*[@placeholder='Create a post']")
	private WebElement contentField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement submitPostButton;
	@FindBy(how = How.XPATH, using = "//div[@class='post bg-white p-1 my-1']")
	private List<WebElement> postContainers;

	// Constructor
	public PostPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void createPost(String content) {
		contentField.sendKeys(content);
		submitPostButton.click();
		Util.wait(2);
	}

	public void validatePostByNameAndContent(String expectedUsername, String expectedPostContent) {
		boolean found = false;
		for (WebElement container : postContainers) {
			String userName = container.findElement(By.tagName("h4")).getText();
			String content = container.findElement(By.tagName("p")).getText();
			if (expectedUsername.equals(userName) && expectedPostContent.equals(content)) {
				found = true;
				break;
			}
		}
		assertTrue(found,
				"The post by [" + expectedUsername + "] and w/ content [" + expectedPostContent + "] was not found");
	}

	public void validatePostByIdAndContent(String id, String expectedPostContent) {
		List<WebElement> contentElements = driver
				.findElements(By.xpath("//a[@href='/profile/" + id + "']/../following-sibling::div/p[@class='my-1']"));

		boolean found = false;
		for (WebElement contentElement : contentElements) {
			if (contentElement.getText().trim().equals(expectedPostContent)) {
				found = true;
				break;
			}
		}
		assertTrue(found, "Post with the content - [" + expectedPostContent + "] & userId - [" + id + "] is not found");
	}

	public void deletePostByIdAndContent(String id, String postContent) {
		Util.wait(2);
		List<WebElement> contentElements = driver
				.findElements(By.xpath("//a[@href='/profile/" + id + "']/../following-sibling::div/p[@class='my-1']"));

		int index = 1;
		for (WebElement contentElement : contentElements) {
			if (contentElement.getText().trim().equals(postContent)) {
				List<WebElement> deleteButtons = driver.findElements(By.xpath("(//a[@href='/profile/" + id
						+ "']/../following-sibling::div/button[@class='btn btn-danger'])[" + index + "]"));
				assertEquals(deleteButtons.size(), 1, "There was none or more than 1 delete buttons");
				deleteButtons.get(0).click();
				Util.wait(2);
			}
			index++;
		}
	}

}
