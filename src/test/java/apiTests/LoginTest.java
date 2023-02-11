package apiTests;

import api.BoraAPI;
import pojo.Post;

public class LoginTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("muradil.erkin@boratechschool.com", "Boratech");

		Post post = BoraAPI.createPost(token, "Murad Test Post from RestAssured  - 1");

		System.out.println(post.text);
		System.out.println(post.name);
		System.out.println(post.date);

	}

}
