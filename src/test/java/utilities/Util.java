package utilities;

import java.util.Set;

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

	/*
	 * Switches the driver focus to the child window
	 * 
	 * @Author: Erlyn Gammad
	 */

	public static void switchToSeparateWindow(WebDriver driver) {
		try {
			String parentHandle = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();

			for (String child : allWindows) {
				if (!child.equals(parentHandle)) {
					driver.switchTo().window(child);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
