package utilities;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {
	/*
	 * Selecting Drop Down List by invisible text
	 * 
	 * @Author: Subhinur Muhammad
	 */
	public static void selectByVisibleText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	/*
	 * Adding string in text field
	 * 
	 * @Author: Subhinur Muhammad
	 */
	public static void addText(WebDriver driver, By locator, String value) {
		WebElement field = driver.findElement(locator);
		field.sendKeys(value);
	}
	
	
	public static String getText(WebDriver driver, By locator) {
		return driver.findElement(locator).getText();
	}

	/*
	 * Clicks on button
	 * 
	 * @Author: Jack Vu
	 * 
	 */
	public static void buttonClickFunction(WebDriver driver, By pathOfButton) {
		try {
			driver.findElement(pathOfButton).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Checks if an element is displayed
	 * 
	 * @Author: Nilupar Erkin
	 */
	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * Sleeps for given number of seconds
	 * 
	 * @Author: Muradil Erkin
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Switches the driver focus to the next available window
	 * 
	 * @Author: Erlyn Gammad
	 */
	public static void switchToNextAvailableWindow(WebDriver driver) {
		try {
			String parentHandle = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();

			for (String child : allWindows) {
				if (!child.equals(parentHandle)) {
					driver.switchTo().window(child);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Open Website**
	 * 
	 * @Author: Wei Wang
	 */

	public static void openWebsite(String website, WebDriver driver) {

		driver.get(website);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}

	/*
	 * Generates a 6 digit numeric code
	 * 
	 * @Author: Muradil Erkin
	 */
	public static int get6DigitCode() {
		Random random = new Random();
		int sixDigit = random.nextInt(999999 + 1 - 100000) + 100000;
		return sixDigit;
	}
	
	
	
	/***Verify****/
	
	public static boolean verifyElementExist(WebDriver driver, By locator) {
		List<WebElement> elems = driver.findElements(locator);
		return elems.size()>0;
	}
	
}
