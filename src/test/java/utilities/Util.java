package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	 * Switch to Alert then confirm
	 *
	 * @Author: Olvia Wang
	 */
	public static void confirmAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}