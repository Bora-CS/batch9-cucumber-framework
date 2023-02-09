package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util {
	
    /*
     * @Author: surayya Abraham
     * 
     */
	public static void dragAndDropAcions(WebDriver driver, By locator1 , By locator2) {
		Actions action = new Actions(driver);
		WebElement drage = driver.findElement(locator1);
		WebElement drop = driver.findElement(locator2);
		 action.dragAndDrop(drage, drop).perform();
	}
	/*
	 * Sleeps for given number of second
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
