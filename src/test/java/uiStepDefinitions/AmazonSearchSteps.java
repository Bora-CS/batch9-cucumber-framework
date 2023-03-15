package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.ObjectRepository.locator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pojo.AmazonSearchResult;
import utilities.DriverManager;
import utilities.ExcelUtil;
import utilities.Util;

public class AmazonSearchSteps {

	private WebDriver driver = DriverManager.getInstance();
	private String searchTerm;

	@Given("I'm on the amazon home page")
	public void i_m_on_the_amazon_home_page() {
		driver.get("https://www.amazon.com/");
	}

	@When("I search for {string}")
	public void i_search_for(String searchTerm) {
		this.searchTerm = searchTerm;
		driver.findElement(locator("HomePage.SearchField")).sendKeys(searchTerm);
		driver.findElement(locator("HomePage.SearchButton")).click();
	}

	@Then("I should see some search results")
	public void i_should_see_some_search_results() {
		try {
			String searchSummaryText = driver.findElement(locator("SearchResultPage.ResultCountSummary")).getText();
			assertTrue(searchSummaryText.contains("results"));
		} catch (NoSuchElementException e) {
			assertTrue(false, "Didn't get any results");
		}
	}

	@Then("I should be able to collect data about the search results")
	public void i_should_be_able_to_collect_data_about_the_search_results() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<AmazonSearchResult> results = new ArrayList<AmazonSearchResult>();

		int itemCount = 1;
		do {
			Util.wait(2);
			List<WebElement> resultCards = wait.until(
					ExpectedConditions.numberOfElementsToBeMoreThan(locator("SearchResultPage.ResultCards"), 10));
			int resultCount = resultCards.size();

			for (int index = 1; index <= resultCount; index++) {
				String titleXpath = "(//div[@data-component-type='s-search-result'])[" + index
						+ "]//div[contains(@class,'title-instructions')]/h2";
				String priceXpath = "(//div[@data-component-type='s-search-result'])[" + index
						+ "]//div[contains(@class,'price-instructions')]//span[@class='a-price']";

				String title = driver.findElement(By.xpath(titleXpath)).getText();
				String price;
				try {
					price = driver.findElement(By.xpath(priceXpath)).getText();
					price = price.replace("\n", ".");
				} catch (NoSuchElementException e) {
					continue;
				}

				if (itemCount > 100) {
					break;
				}

				double actualPrice = Double.valueOf(price.replace("$", ""));
				results.add(new AmazonSearchResult(itemCount, title, actualPrice));
				itemCount++;
			}

			if (itemCount > 100) {
				break;
			}

			driver.findElement(By.xpath("//a[contains(@aria-label, 'Go to next page')]")).click();

		} while (itemCount < 100);

		ExcelUtil.writeAmazonSearchResultToFile(results, searchTerm);

	}

}
