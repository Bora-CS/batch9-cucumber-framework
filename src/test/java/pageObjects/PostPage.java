package pageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Util;

public class PostPage {

	// Local Variable
	private WebDriver driver;

	// Elements
	private By contentField = By.xpath("//*[@placeholder='Create a post']");
	private By submitPostButton = By.xpath("//input[@type='submit']");
	private By postContainers = By.xpath("//div[@class='post bg-white p-1 my-1']");

	// Constructor
	public PostPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public void createPost(String content) {
		driver.findElement(contentField).sendKeys(content);
		driver.findElement(submitPostButton).click();
		Util.wait(2);
	}

	public void validatePostByNameAndContent(String expectedUsername, String expectedPostContent) {
		boolean found = false;
		List<WebElement> containers = driver.findElements(postContainers);
		for (WebElement container : containers) {
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
