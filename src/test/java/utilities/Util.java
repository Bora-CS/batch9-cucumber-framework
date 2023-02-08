package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	/*
	 * Checks if an element is displayed
	 * 
	 * @Author: Nilupar Erkin
	 */
	
	public static boolean isElementDisplayed(WebDriver driver, String xPathOfElement) {
		try {
			WebElement element = driver.findElement(By.xpath(xPathOfElement));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		
	}

	/*
	 * Sleeps for given number of seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
