package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Util {

	/*
	 * Sleeps for given number of seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Select Drop-down option
	 * @author Wenji Zou
	 */
	public static void dropDownSelect(WebDriver driver, String dorpDownXpath, String optionValue) {
		Select dropDown = new Select(driver.findElement(By.xpath(dorpDownXpath)));
		dropDown.selectByValue(optionValue);
		
	}
	
	
	
	
}
