package apiStepDefinitions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import api.BoraAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.DataManager;

public class Common {

	private DataManager dataManager = DataManager.getInstance();

	@Given("[API] user is logged in")
	public void api_user_is_logged_in(DataTable dataTable) {
		Map<String, String> data = dataTable.asMaps().get(0);
		String token = BoraAPI.login(data.get("username"), data.get("password"));
		assertNotNull(token);
		dataManager.setToken(token);
	}

	@Then("[API] user should see a {int} status code")
	public void api_user_should_see_a_status_code(Integer expectedStatusCode) {
		int actualStatusCode = dataManager.getResponse().statusCode();
		assertEquals(expectedStatusCode, actualStatusCode);
	}

	@Then("[API] the response body should contain given message")
	public void api_the_response_body_should_contain_given_message(DataTable dataTable) {
		List<Map<String, String>> dataSets = dataTable.asMaps();
		String actualBodyString = dataManager.getResponse().body().asString();
		System.out.println(dataSets);
		for (Map<String, String> data : dataSets) {
			String message = data.get("message");
			if (message != null) {
				assertTrue(actualBodyString.contains(message), "Expected message <" + message
						+ "> is not found in the response body <" + actualBodyString + ">");
			}
		}
	}
}
