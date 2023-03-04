package dataTransform;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojo.Education;
import pojo.Experience;

public class ExperienceDataTransform {

	@DataTableType
	public Experience experienceConvert(Map<String, String> data) {
		Experience experience = new Experience(data.get("company") == null ? "" : data.get("company"),
				data.get("title") == null ? "" : data.get("title"),
				data.get("location") == null ? "" : data.get("location"),
				data.get("from") == null ? "" : data.get("from"), data.get("to") == null ? "" : data.get("to"),
				Boolean.valueOf(data.get("current") == null ? "false" : data.get("current")),
				data.get("description") == null ? "" : data.get("description"));
		return experience;
	}

}
