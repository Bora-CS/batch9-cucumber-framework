package utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	/*
	 * Selecting Drop Down List by invisible text
	 * @Author: Subhinur Muhammad
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	/*
	 * Adding string in text field
	 * @Author: Subhinur Muhammad
	 */
	public static void  addText(WebDriver driver, By locator, String value) {
		WebElement field = driver.findElement(locator); 
		field.sendKeys(value);
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
	
	/*
	 * sendKey function
	 * Author:Joyce
	 */
	public static void sendKey(WebDriver driver,String value,String xpathLocator) {
		WebElement ele = driver.findElement(By.xpath(xpathLocator));
		ele.clear();
		try {
			ele.sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Open Website
	 * 
	 * @Author: Wei Wang
	 */
	public static void openWebsite(String website, WebDriver driver) {

		driver.get(website);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
}
