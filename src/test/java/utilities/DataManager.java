package utilities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.restassured.response.Response;
import pojo.User;

public class DataManager {

	// Data Manager
	private static DataManager dataManager;

	private DataManager() {
	};

	public static DataManager getInstance() {
		if (dataManager == null) {
			dataManager = new DataManager();
		}
		return dataManager;
	}

	public static void cleanUp() {
		if (dataManager != null) {
			dataManager = null;
		}
	}

	// Data
	private String token;
	private Response response;
	private User user;
	private String postContent;

	public String getToken() {
		assertNotNull(token, "DataManager - Token is not available");
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Response getResponse() {
		assertNotNull(response, "DataManager - Response is not available");
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public User getUser() {
		assertNotNull(user, "DataManager - User is not available");
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPostContent() {
		assertNotNull(postContent, "DataManager - PostContent is not available");
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
}
