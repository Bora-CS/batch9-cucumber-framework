package runners;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.DriverManager;
import utilities.Util;

public class LoginTest {

	public static void main(String[] args) {

		WebDriver driver = DriverManager.getInstance();
		driver.get("https://boratech-practice-app.onrender.com/");

		try {
			// Homepage
			driver.findElement(By.xpath("//a[text()='Login']")).click();

			// LoginPage
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("muradil.erkin@boratechschool.com");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Boratech");
			driver.findElement(By.xpath("//input[@value='Login']")).click();

			Util.wait(2);

			// DashboardPage
			WebElement subtitle = driver.findElement(By.xpath("//p[@class='lead']"));
			assertTrue(subtitle.getText().contains("Welcome"), "Sign In Failed");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverManager.tearDown();
		}

	}

}
