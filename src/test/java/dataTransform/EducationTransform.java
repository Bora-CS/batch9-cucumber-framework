package dataTransform;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojo.Education;

public class EducationTransform {

	@DataTableType
	public Education educationConvert(Map<String, String> data) {
		Education education = new Education(data.get("school"), data.get("degree"), data.get("fieldofstudy"),
				data.get("from"), data.get("to"), Boolean.valueOf(data.get("current")), data.get("description"));
		return education;
	}

}
