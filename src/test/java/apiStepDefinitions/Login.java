package apiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import api.BoraAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DataManager;

public class Login {

	private DataManager dataManager = DataManager.getInstance();

	@Given("[API] user is logged in")
	public void api_user_is_logged_in(DataTable dataTable) {
		Map<String, String> data = dataTable.asMaps().get(0);
		String token = BoraAPI.login(data.get("username"), data.get("password"));
		assertNotNull(token);
		dataManager.setToken(token);
	}

}
