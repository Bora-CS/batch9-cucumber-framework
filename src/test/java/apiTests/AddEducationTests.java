package apiTests;

import api.BoraAPI;

/*
 * @Author: Subhinur.Muhammad
 */

public class AddEducationTests {
		public static void main(String[] args) {
			String token = BoraAPI.login("subhinur.muhammadd@gmail.com", "Subhinur229!");
			BoraAPI.addEducation(token, "Istanbul Sehir University", "Bachelor", "Sciology", "2016-8-30", "2020-6-30", "Statistics, Anthropology...");		

}
}
