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
    * Selectdate
    * 
    * @Author:Yiping Chen
    */
	public static void selectdate(WebDriver driver,String calendarLocator) {
		driver.findElement(By.xpath(calendarLocator)).click();
	}
	
	
}
