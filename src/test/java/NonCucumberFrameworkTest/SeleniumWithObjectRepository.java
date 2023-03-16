package NonCucumberFrameworkTest;

import org.openqa.selenium.WebDriver;

import utilities.DriverManager;
import utilities.Util;

import static utilities.ObjectRepository.locator;

public class SeleniumWithObjectRepository {

	public static void main(String[] args) {
		try {
			WebDriver driver = DriverManager.getInstance();
			driver.get("https://www.amazon.com/");

			driver.findElement(locator("HomePage.SearchField")).sendKeys("Shampoo");
			driver.findElement(locator("HomePage.SearchButton")).click();

			Util.wait(2);

			String resultSummary = driver.findElement(locator("SearchResultPage.ResultCountSummary")).getText();
			System.out.println(resultSummary);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DriverManager.tearDown();
		}
	}

}
