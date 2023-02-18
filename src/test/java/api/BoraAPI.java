package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateEducationRequestBody;
import pojo.CreateExperienceRequestBody;
import pojo.CreatePostRequestBody;
import pojo.Education;
import pojo.Experience;
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

	/*
	 * adds a new experience to profile
	 * 
	 * Author: Erlyn Gammad
	 */
	public static Experience addExperience(String token, String company, String title, String location, String from,
			String to, String description) {
		String endpoint = "/api/profile/experience";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		CreateExperienceRequestBody body = new CreateExperienceRequestBody(company, title, location, from, to,
				description);
		request.body(body);

		Response response = request.put(endpoint);
		Experience experience = response.as(Experience.class);
		return experience;
	}

	/*
	 * adds new education to profile
	 * 
	 * Author: Erlyn Gammad
	 */
	public static Education addEducation(String token, String school, String degree, String fieldofstudy, String from,
			String to, String description) {
		String endpoint = "/api/profile/education";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		CreateEducationRequestBody body = new CreateEducationRequestBody(school, degree, fieldofstudy, from, to,
				description);
		request.body(body);

		Response response = request.put(endpoint);
		Education education = response.as(Education.class);
		return education;
	}
}
