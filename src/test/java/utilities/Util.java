package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {

	
	/*
	 * Clicks on buttons based on xpath of button 
	 * @Author: Jack Vu 
	 * 
	 */
	public static void buttonClickFunction(WebDriver driver, String xpathOfButton) {
		driver.findElement(By.xpath(xpathOfButton)).click();
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
