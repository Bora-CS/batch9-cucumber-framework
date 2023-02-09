package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {

	/*
	 * Selecting drop down list by invisible text;
	 * 
	 * @Author: Subhinur Muhammad;
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
