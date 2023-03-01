package uiStepDefinitions;


}
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import groovy.transform.Undefined;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DriverManager;
public class Education {
	public static void main(String[] args) {
		private WebDriver driver = DriverManager.getInstance();
		public class AddEducation {
			private WebDriver driver = DriverManager.getInstance();
			@Given("user clickon the education button")
			public void user_clickon_the_education_button() {
				driver.findElement(By.xpath("//a[@href='/add-education']")).click();
			}
			@Given("user add education")
			public void user_add_education() {
				driver.findElement(By.xpath("//input[@name='school']")).sendKeys("New school today");
				driver.findElement(By.xpath("//input[@name='degree']")).sendKeys("New degree today");
				driver.findElement(By.xpath("//input[@name='fieldofstudy']")).sendKeys("New study today");
				driver.findElement(By.xpath("//input[@name='from']")).sendKeys("01012020");
				driver.findElement(By.xpath("//input[@name='to']")).sendKeys("01012023");
			}
			@Given("user submit button")
			public void user_submit_button() throws InterruptedException {
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				Thread.sleep(3000);
			}
			@Then("user on the dashboard")
			public void user_on_the_dashboard() {
				String expectedUrl = "https://boratech-practice-app.onrender.com/dashboard";
				String actualUrl = driver.getCurrentUrl();
				assertEquals(expectedUrl, actualUrl);
				String expectedTitleText = "Dashboard";
				String actualTitleText = driver.findElement(By.xpath("//h1[@class='large text-primary']")).getText();
				assertEquals(expectedTitleText, actualTitleText);
			}
		}

		
		sdkfjs;ldfj; slkdjf
		
		dkjfldkjf;l jdlkj










