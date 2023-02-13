package apiTests;

import api.BoraAPI;
import pojo.Post;

public class LoginTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("claire@gmail.com", "Du1234");

		Post post = BoraAPI.createPost(token, "This is the new message from RestAssured  - 1");

		System.out.println(post.text);
		System.out.println(post.name);
		System.out.println(post.date);

	}

}
