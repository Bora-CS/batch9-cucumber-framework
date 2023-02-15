package api;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreatePostRequestBody;
import pojo.EducationRequestBody;
import pojo.ExperienceRequestBody;
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
	 * Create Education
	 * 
	 * @ Author: Wenji Zou
	 */
	public static void createEducation(String token, String school, String degree, String fieldofstudy, String from,
			String to, String description, boolean current) {

		String endpoint = "/api/profile/education";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		EducationRequestBody body = new EducationRequestBody(school, degree, fieldofstudy, from, to, description,
				current);
		request.body(body);

		Response response = request.put(endpoint);
		// response.prettyPrint();
		JsonPath jp = response.jsonPath();
		String company = jp.get("company");
		System.out.println(company);
		String bio = jp.get("bio");
		System.out.println(bio);
		ArrayList<String> skills = jp.get("skills");
		System.out.println(skills);
		ArrayList<String> schools = jp.get("education.school");
		System.out.println(schools);
		ArrayList<String> degrees = jp.get("education.degree");
		System.out.println(degrees);
		ArrayList<String> des = jp.get("education.description");
		System.out.println(des);

	}

	/*
	 * Create Experience
	 * 
	 * @ Author: Wenji Zou
	 */
	public static void createExperience(String token, String company, String title, String location, String from,
			String to, String description, boolean current) {

		String endpoint = "/api/profile/experience";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");

		ExperienceRequestBody body = new ExperienceRequestBody(company, title, location, from, to, description,
				current);
		request.body(body);

		Response response = request.put(endpoint);
		response.prettyPrint();

	}

}
