package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Util {
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
	 * moveToElement
	 * 
	 * @Mustafa
	 */
	public static void moveToElement(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);

		WebElement targetLocation = driver.findElement(By.id("toolTipButton"));
		actions.moveToElement(targetLocation).build().perform();
	}
}