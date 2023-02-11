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
		body.put("email", "shaoling.stouder@gmail.com");
		body.put("password", "591159slS@");

		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.statusCode();
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		if (actualStatusCode == StatusCodes.OK.value()) {
			System.out.println("Test Passed");
		}else {
		System.out.println("Test Failed");

	}

}
