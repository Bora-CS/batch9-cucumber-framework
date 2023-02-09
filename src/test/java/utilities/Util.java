package utilities;

import org.openqa.selenium.JavascriptExecutor;
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
	 * @Author Ning Yang
	use javascriptExecutor method click target element	
	*/
	public static void javaScriptClick(WebDriver driver, WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click()", elem);
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
