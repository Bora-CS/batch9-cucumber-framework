package apiTests;

import api.BoraAPI;

public class EducationTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("wenji.zou.z@gmail.com", "123456");

		BoraAPI.createEducation(token, "Best Cook Academy", "Bachelor", "Cooking", "2020-01-01", "2020-02-02",
				"Fruit and vegetables keep us alive.", false);

		

	}

}
