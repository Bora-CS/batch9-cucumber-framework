package apiTests;

import api.BoraAPI;

public class ExperienceTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("wenji.zou.z@gmail.com", "123456");

		BoraAPI.createExperience(token, "Fairfax Firerescue", "Firefighter", "Virginia", "2019-01-01", "2021-02-02",
				"I am a super hero!", false);
	}

}
