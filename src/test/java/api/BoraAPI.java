package api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreatePostRequestBody;
import pojo.LogInRequestBody;
import pojo.LogInResponseBody;
import pojo.Post;
import utilities.StatusCodes;

public class BoraAPI {

	public static String login(String email, String password) {

		String endpoint = "/api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		LogInRequestBody body = new LogInRequestBody(email, password);
		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.statusCode();

		if (actualStatusCode != StatusCodes.OK.value()) {
			System.out.println("Login Failed");
		}

		LogInResponseBody loginResponseBody = response.as(LogInResponseBody.class);

		return loginResponseBody.getToken();

	}

	public static Post createPost(String token, String content) {

		String endpoint = "/api/posts";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		CreatePostRequestBody body = new CreatePostRequestBody(content);
		request.body(body);

		Response response = request.post(endpoint);
		Post post = response.as(Post.class);
		return post;

	}

	public static void getCurrentUserProfile(String token) {

		String endpoint = "/api/profile/me";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);

		Response response = request.get(endpoint);
		response.prettyPrint();
		// TODO: create pojo for profile, which is big project

	}

}
