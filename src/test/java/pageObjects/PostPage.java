package pageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

}
