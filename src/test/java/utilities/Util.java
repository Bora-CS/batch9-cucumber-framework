package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util {
	
    /*
     * Drag and drop actions 
     * @Author: Surayya Abraham 
     */
	public static void dragAndDropAcions(WebDriver driver, By soureLocator , By targetLocator) {
		Actions action = new Actions(driver);
		WebElement drage = driver.findElement(soureLocator);
		WebElement drop = driver.findElement(targetLocator);
		 action.dragAndDrop(drage, drop).perform();	 
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
