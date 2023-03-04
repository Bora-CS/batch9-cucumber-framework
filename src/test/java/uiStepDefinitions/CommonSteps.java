package uiStepDefinitions;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import utilities.PageManager;

public class CommonSteps {

	private PageManager pages = PageManager.getInstance();

	@Given("user is logged in")
	public void login(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		pages.loginPage().navigate();
		pages.loginPage().login(data.get("username"), data.get("password"));
		pages.dashboardPage().validate();
	}

}
