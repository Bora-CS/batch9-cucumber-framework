package utilities;

import org.openqa.selenium.WebDriver;

public class Util {

	
	/*
	 *  Switches the driver focus between the windows.
 	 *  Author Jolene Jones
 	 *  Published 2/8/2023
	 */
		public static void switchTo( String pageURL, WebDriver driver ) {
			
			
			String pageURL = driver.getCurrentUrl();
			driver.switchTo().window(pageURL);


	}

}