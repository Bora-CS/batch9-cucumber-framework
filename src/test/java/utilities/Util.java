package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {

	/*
	 * Clicks on buttons
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
