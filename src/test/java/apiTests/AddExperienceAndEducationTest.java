package apiTests;

import java.util.Arrays;

import api.BoraAPI;
import pojo.AddExpeEduResponseBody;
import pojo.Education;
import pojo.Experience;

public class AddExperienceAndEducationTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("joycechen@test.com", "123456");

		BoraAPI.AddExperience(token, "BoraTech-1", "Student", "VA", "2020-06-01", "2021-12-25", false, "nice learning");

		AddExpeEduResponseBody response = BoraAPI.AddEducation(token, "Bora", "BA degree", "automation test",
				"2020-06-01", "2021-12-25", false, "Learn java,Selenium,SQL,APIs,framework");

		String[] skill = response.skills;
		System.out.println(Arrays.toString(skill));
		System.out.println(response._id);
		System.out.println(response.user);
		System.out.println(response.bio);
		System.out.println(response.company);
		System.out.println(response.location);
		System.out.println(response.date);
		Education[] educations = response.education;
		for (Education edu : educations) {
			System.out.println(edu.school);
		}
		Experience[] experiences = response.experience;
		for (Experience exp : experiences) {
			System.out.println(exp.company);
		}

	}

}
