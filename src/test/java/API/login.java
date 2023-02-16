package API;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class login {

	public static void main(String[] args) {
		String endPoint = "api/auth";
		
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		
		RequestSpecification request =RestAssured.given();
		request.header("ContentType", "application/json");
		
		Map<String, String> body= new HashMap<>();
		body.put("name","zulfia");
		body.put("email","zulfia.erk@gmail.com");
		
		request.body(body);
		
		request.post(endPoint);
		
		Response response = request.post(endPoint);
		int statusCode = response.statusCode();
		
		String responseBody = response.getBody().asPrettyString();
		System.out.println(statusCode);
		System.out.println(responseBody);
	}

}
