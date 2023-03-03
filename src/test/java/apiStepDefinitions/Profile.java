package apiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import api.BoraAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pojo.Education;
import pojo.Experience;
import utilities.DataManager;

public class Profile {

	private DataManager dataManager = DataManager.getInstance();

	@When("[API] user tries to add an experience")
	public void api_user_tries_to_add_an_experience(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		Experience experience = new Experience(data.get("company"), data.get("title"), data.get("location"),
				data.get("from"), data.get("to"), Boolean.valueOf(data.get("current")), data.get("description"));
		Response response = BoraAPI.addExperienceNoValidation(dataManager.getToken(), experience);
		dataManager.setResponse(response);
	}

	@When("[API] user tries to add an education")
	public void api_user_tries_to_add_an_education(Education education) {
		Response response = BoraAPI.addEducationNoValidation(dataManager.getToken(), education);
		dataManager.setResponse(response);
	}

}
