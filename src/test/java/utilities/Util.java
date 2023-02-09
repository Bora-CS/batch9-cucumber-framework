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
	
	/*
	 * HomeWork2-7
	 * 
	 * @Author: claire zhang
	 */
	public static void targetLocation(WebDriver driver, String targetLocation) {
			
		driver.findElement(By.xpath(targetLocation)).click();
		driver.switchTo().alert().accept();
	
	}
}
