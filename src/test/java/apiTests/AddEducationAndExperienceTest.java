package apiTests;

import api.BoraAPI;
import pojo.Education;
import pojo.Experience;

public class AddEducationAndExperienceTest {

	public static void main(String[] args) {
		String token = BoraAPI.login("gammaderlyn@gmail.com", "Erlyn123");

		Education newEdu = BoraAPI.addEducation(token, "Bora Tech", "No degree", "Test Automation Engineer Course",
				"11-01-2022", "04-30-2023", "I am learning so much about automation");
		Experience newExp = BoraAPI.addExperience(token, "PPD", "Scientist", "Richmond,VA", "01-01-2021", "07-01-2022",
				"I was working with vaccines");

	}

}
