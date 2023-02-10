package utilities;

import org.openqa.selenium.By;
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
	 * Insert text in text box
	 * @Author: Flora Erkin
	 */
	public static void insertText(WebElement driver , String text , By locator) {
		WebElement textBox = driver.findElement(locator);
		textBox.sendKeys(text);
	}
}
