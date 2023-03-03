package apiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import api.BoraAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.DataManager;

public class Login {

	private DataManager dataManager = DataManager.getInstance();

	@Given("[API] user tries to login")
	public void api_user_tries_to_login(DataTable dataTable) {
		Map<String, String> data = dataTable.asMaps().get(0);
		Response response = BoraAPI.loginNoValidation(data.get("username"), data.get("password"));
		assertNotNull(response);
		dataManager.setResponse(response);
	}

}
