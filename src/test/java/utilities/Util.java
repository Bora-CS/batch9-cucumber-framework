package utilities;

import org.openqa.selenium.WebElement;

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
	 * Clear and enter
	 * @Author: Flora Erkin
	 */
	public static void sendKeysToElement(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}
}
