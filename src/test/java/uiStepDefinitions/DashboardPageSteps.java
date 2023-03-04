package uiStepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.PageManager;

public class DashboardPageSteps {

	private PageManager pages = PageManager.getInstance();

	@Then("user should be on the dashboard page")
	public void validateDashboard() {
		pages.dashboardPage().validate();
	}

	@When("user clicks on the add experience button")
	public void addExperience() {
		pages.dashboardPage().navigateToAddExperiencePage();
	}

	@When("user clicks on the add education button")
	public void addEducation() {
		pages.dashboardPage().navigateToAddEducationPage();
	}

	@Then("the experience with the given company name should be displayed")
	public void findExperienceByCompanyName(DataTable dataTable) {
		pages.dashboardPage().findExperienceByCompanyName(dataTable.asMap().get("company"));
	}

}
