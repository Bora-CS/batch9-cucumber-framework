package api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.*;
import utilities.StatusCodes;

public class BoraAPI {

	public static String login(String email, String password) {
		Response response = loginNoValidation(email, password);
		int actualStatusCode = response.statusCode();
		assertEquals(StatusCodes.OK.value(), actualStatusCode);

		LogInResponseBody loginResponseBody = response.as(LogInResponseBody.class);
		return loginResponseBody.getToken();
	}

	public static Response loginNoValidation(String email, String password) {
		String endpoint = "/api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		LogInRequestBody body = new LogInRequestBody(email, password);
		request.body(body);

		Response response = request.post(endpoint);
		return response;
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

		assertEquals(StatusCodes.OK.value(), response.statusCode());

		Post post = response.as(Post.class);
		return post;

	}

	public static List<Post> getAllPosts(String token) {

		String endpoint = "/api/posts";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);

		Response response = request.get(endpoint);
		List<Post> posts = response.jsonPath().getList("", Post.class);
		return posts;

	}

	public static Profile getCurrentUserProfile(String token) {

		String endpoint = "/api/profile/me";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);

		Response response = request.get(endpoint);
		return response.as(Profile.class);

	}

	public static UpdatedProfile addExperience(String token, Experience data) {
		Response response = addExperienceNoValidation(token, data);
		UpdatedProfile updatedProfile = response.as(UpdatedProfile.class);
		return updatedProfile;

	}

	public static Response addExperienceNoValidation(String token, Experience data) {
		String endpoint = "/api/profile/experience";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-type", "application/json");
		request.header("x-auth-token", token);

		request.body(data);

		Response response = request.put(endpoint);
		return response;
	}

	public static UpdatedProfile addEducation(String token, Education data) {

		String endpoint = "/api/profile/education";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-type", "application/json");
		request.header("x-auth-token", token);

		request.body(data);

		Response response = request.put(endpoint);
		UpdatedProfile updatedProfile = response.as(UpdatedProfile.class);
		return updatedProfile;

	}

	public static void deletePostById(String token, String postId) {

		String endpoint = "/api/posts/{id}";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);

		request.pathParam("id", postId);

		Response response = request.delete(endpoint);
		String message = response.jsonPath().get("msg");
		System.out.println(message);

	}

}
