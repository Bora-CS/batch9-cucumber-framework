package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	 * switch to iFrame
	 * 
	 * @Author: Andy Zeng
	 */
	public static void iFrame(WebDriver driver, String frameElement) {
		WebElement iFrame = driver.findElement(By.xpath(frameElement));
		driver.switchTo().frame(iFrame);
		
	}
	

}
