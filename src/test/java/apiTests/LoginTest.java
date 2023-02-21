package apiTests;

import java.util.ArrayList;
import java.util.List;

import api.BoraAPI;
import pojo.*;

public class LoginTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("muradil.erkin@boratechschool.com", "Boratech");

		// Delete all current user's posts
//		Profile profile = BoraAPI.getCurrentUserProfile(token);
//
//		String myId = profile.user._id;
//		System.out.println("My Id: " + myId);
//
//		List<Post> posts = BoraAPI.getAllPosts(token);
//		int numberOfPosts = 0;
//		for (Post post : posts) {
//			if (post.user.equals(myId)) {
//				System.out.print(numberOfPosts++);
//				BoraAPI.deletePostById(token, post._id);
//			}
//		}

		// Get current user profile
//		Profile profile = BoraAPI.getCurrentUserProfile(token);
//		System.out.println(profile.user.name);

		// Add experience
//		Experience data = new Experience("Bora Consulting Solutions", "Instructor", "Annandale, VA", "2018-10-01", null,
//				true, "POJO Experience");
//
//		BoraAPI.addExperience(token, data);

		// Add education and validate
//		Education expectedEducation = new Education("BoraTech", "Certified SDET", "SDET", "02/01/2022", "08/01/2022",
//				false, "Got some skills to do test automation");
//
//		UpdatedProfile updatedProfile = BoraAPI.addEducation(token, expectedEducation);
//		boolean found = false;
//		for (Education education : updatedProfile.education) {
//			if (education.equals(expectedEducation)) {
//				found = true;
//				break;
//			}
//		}
//
//		System.out.println(found ? "Education added successfully" : "Test failed, expected education not found");

	}

}
