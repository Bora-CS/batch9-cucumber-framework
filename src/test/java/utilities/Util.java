package utilities;

import org.openqa.selenium.WebDriver;

public class Util {

	
	/*
	 *  Switches the driver focus between the windows
	 *  second edition 
	 *  please let this be the last time 
 	 *  Author Jolene Jones
	 */
		public static void switchTo(WebDriver driver, String pageURL ) {
			
			
			String pageURL = driver.getCurrentUrl();
			driver.switchTo().window(pageURL);


	}

}