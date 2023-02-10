package utilities;

import org.openqa.selenium.By;
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
	 * Switches the driver focus between the windows.
	 * 
	 * @Author Jolene Jones
	 */

	public static void switchTo(WebDriver driver, By locater) {

		String parent = driver.getWindowHandle();
		driver.findElement(locater).click();
		for (String newwin : driver.getWindowHandles()) {
			driver.switchTo().window(newwin);
		}
		driver.close();
		driver.switchTo().window(parent);

	}

}

}