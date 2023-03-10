package pageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void createPost(String content) {
		contentField.sendKeys(content);
		clickSubmitButton();
		Util.wait(2);
	}
	
	public void clickSubmitButton() {
		Util.wait(3);
		submitPostButton.click();
	}
	
	public String getErrorMessage() {
		Util.wait(2);
		return contentField.getAttribute("validationMessage");
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

	public void thumbsUpForGivenUser(String username, String content) {
		String xpath = "(//*[text()='" + username + "']/../../..//*[text()='" + content
				+ "']/following-sibling::button)[1]";

		Util.buttonClickFunction(driver, By.xpath(xpath));

	}

	public String getThumbsUpNumberForGivenUser(String username, String content) {
		String xpath = "(//*[text()='" + username + "']/../../..//*[text()='" + content
				+ "']/following-sibling::button/span)[1]";
		Util.wait(3);
		return Util.getText(driver, By.xpath(xpath));
	}

	public void thumbsDownForGivenUser(String username, String content) {
		String xpath = "(//*[text()='" + username + "']/../../..//*[text()='" + content
				+ "']/following-sibling::button)[2]";
		Util.wait(3);
		Util.buttonClickFunction(driver, By.xpath(xpath));

	}

	public boolean verifyThumbsUpNumberForGivenUser(String username, String content) {
		String xpath = "(//*[text()='" + username + "']/../../..//*[text()='" + content
				+ "']/following-sibling::button/span)[2]";

		return Util.verifyElementExist(driver, By.xpath(xpath));

	}

}
