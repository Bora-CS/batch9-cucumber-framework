package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

	/*
	* prints Hello
	* @ @Author: Chiang
	*/
	public static void main(String[] args) {
		String s= new String("Hello");
		s.concat("Java");
		System.out.println(s);// prints Hello
		}
	}


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
}
