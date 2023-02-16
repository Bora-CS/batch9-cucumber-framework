package apiTests;

import api.BoraAPI;

public class JolenesEducationAndExperienceTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("maoxuan11@gmail.com", "******");

		BoraAPI.jolenesEducation(token, "Boratech", "Automation Test Engineer", "Tech", "2022-11-01", "",
				"happy learning journey to make you successful as Murad ");

		BoraAPI.jolenesExperience(token, "Cashier", "bb.q Chicken", "Richmond,VA", "2018-08-01", "2018-12-01",
				"collecting money from customers in exchange for tasty Korean fried chicken");

	}

}
