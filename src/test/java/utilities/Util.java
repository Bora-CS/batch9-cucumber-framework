package utilities;

import org.openqa.selenium.WebDriver;

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

}
	/*
	 * Hopefully rhis should work
	 * Switches the driver focus between the windows. 
	 * Author Jolene Jones 
	 * 2nd edition 
	 * Published 2/8/2023
	 */

	public static void switchTo(String pageURL, WebDriver driver) {

		String pageURL = driver.getCurrentUrl();
		driver.switchTo().window(pageURL);

	}

}