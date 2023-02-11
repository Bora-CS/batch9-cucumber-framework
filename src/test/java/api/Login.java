package api;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {

	public static void main(String[] args) {

		String endpoint = "/api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		Map<String, String> body = new HashMap<>();
		body.put("email", "murad@test.com");
		body.put("password", "abc1234");

		request.body(body);

		Response response = request.post(endpoint);
		int statusCode = response.statusCode();
		String responseBody = response.getBody().asString();

		System.out.println(statusCode);
		System.out.println(responseBody);

	}

}
