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
	public static void dragAndDropAcions(WebDriver driver, String sourceXpath , String targetXpath) {
		Actions action = new Actions(driver);
		WebElement drage = driver.findElement(By.xpath("sourceXpath"));
		WebElement drop = driver.findElement(By.xpath("targetXpath"));
		 action.dragAndDrop(drage, drop).perform();
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

}
