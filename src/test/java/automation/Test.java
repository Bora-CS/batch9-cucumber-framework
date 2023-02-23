package automation;

import java.util.Iterator;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.DriverManager;

public class Test {

	public static WebDriver driver;

	public static void main(String[] args) {

		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int sixDigit = random.nextInt(999999 + 1 - 100000) + 100000;
			System.out.println(sixDigit);
		}

	}

}
