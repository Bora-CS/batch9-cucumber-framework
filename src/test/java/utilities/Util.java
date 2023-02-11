package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {

	/*
	 * 
	 * select multi option
	 * @Author: Sedef Akyo
	 */
	public static void selectMulti(WebDriver driver, By locator, String value1,String value2) {
	Select multiElem = new Select(driver.findElement(locator));

	multiElem.selectByValue(value1);
	multiElem.selectByValue(value2);
	
	List<WebElement> lists = multiElem.getOptions();
	for(WebElement options:lists) {
		System.out.println("The options of the dropdown are :"+ options.getText());
		
		
			}
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
