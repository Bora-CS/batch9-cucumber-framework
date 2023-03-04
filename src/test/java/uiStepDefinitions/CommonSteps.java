package uiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.DriverManager;

public class CommonSteps {

	private WebDriver driver = DriverManager.getInstance();
	private LoginPage loginPage = new LoginPage(driver);
	private DashboardPage dashboardPage = new DashboardPage(driver);

	@Given("user is logged in")
	public void login(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		loginPage.navigate();
		loginPage.login(data.get("username"), data.get("password"));
		dashboardPage.validate();
	}

}
