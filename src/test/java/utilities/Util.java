package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

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
	
	/*
	 * sendKey function
	 * Author:Joyce
	 */
	public static void sendKey(WebDriver driver,String value,String xpathLocator) {
		WebElement ele = driver.findElement(By.xpath(xpathLocator));
		ele.clear();
		try {
			ele.sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
