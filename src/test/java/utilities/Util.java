package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

	/*
	 * Sleeps for given number of seconds
	 */
	public static void uplad (WebDriver driver, String uploadElement) {		
			try {
				
			/*
			 * upload file
			 * @Author: Inhae Jeong
			 * 
			 */
				WebElement upload = driver.findElement(By.xpath(uploadElement));
				upload.sendKeys("C:/Users/Desktop/upload.png");
				System.out.println("File is Uploaded Successfully");

				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
}


