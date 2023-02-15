package apiTests;

import api.BoraAPI;
import pojo.Education;

public class AddEducationAndExperienceTest {

	public static void main(String[] args) {
		String token = BoraAPI.login("gammaderlyn@gmail.com", "Erlyn123"); 
		
		Education education =BoraAPI.addEducation(token, "Bora Tech", "No degree","Test Automation Engineer Course", "11-01-2022", "04-30-2023", "I am learning so much about automation");
		for(Education e: education) {
			System.out.println(education.user);
		}
		

	}

}
