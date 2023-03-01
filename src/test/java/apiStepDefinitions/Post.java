package apiStepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import api.BoraAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utilities.DataManager;
import utilities.Util;

public class Post {

	private DataManager dataManager = DataManager.getInstance();

	@Then("[API] user can create a post")
	public void createPost(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		String uniqueContent = data.get("content") + Util.get6DigitCode();
		pojo.Post post = BoraAPI.createPost(dataManager.getToken(), uniqueContent);
		assertEquals(uniqueContent, post.text);
	}

}
