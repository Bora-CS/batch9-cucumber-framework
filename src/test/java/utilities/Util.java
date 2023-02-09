package utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


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

}
