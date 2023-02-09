package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {

	public static void commandClearFunction(WebDriver driver) {
		try {
			driver.findElement(By.id("UserName")).clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	/*
	 * Sleeps for given number of seconds
	 * 
	 * @Author: Nancy Nguyen
	 */
	
			
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
