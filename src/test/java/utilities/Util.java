package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Util {

	/*
	 * moveToElement
	 * 
	 * @Author: Mustafa W
	 */
	public static void  moveToElement() throws InterruptedException {
		System.setProperty("webdriver.chrome,driver", "src/test/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		
		WebElement targetLocation = driver.findElement(By.id("toolTipButton"));
		Thread.sleep(3000);
		actions.moveToElement(targetLocation).build().perform();
	}

}
