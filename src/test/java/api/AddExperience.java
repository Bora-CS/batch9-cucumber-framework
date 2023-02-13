package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AddExperience {

	
	public static void CreatNewExperience(String token, String company, String title, String location, String from, String to, String description) {

		String endpoint = "api/profile/experience";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
	
		request.header("x-auth-token", token);
		request.header("Content-Type", "application/json");
	
		pojo.CreatNewExperience body = new pojo.CreatNewExperience(company, title, location, from, to, description);
		request.body(body);
		
		Response response = request.put(endpoint);
		response.prettyPrint();
		
		
	}
	
}
