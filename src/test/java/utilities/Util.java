package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {

	
	
	
	public static void commandClearFunction(WebDriver driver) {
		driver.findElement(By.id("UserName")).clear();
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
