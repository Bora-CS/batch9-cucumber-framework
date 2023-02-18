package pojo;

/*
 * Class that mimics the adding experience request body structure and constructor that initializes the experience parameters 
 * 
 * Author: Erlyn Gammad
 */
public class CreateExperienceRequestBody {
	public String company;
	public String title;
	public String location;
	public String from;
	public String to;
	public String description;

	public CreateExperienceRequestBody(String company, String title, String location, String from, String to,
			String description) {
		this.company = company;
		this.title = title;
		this.location = location;
		this.from = from;
		this.to = to;
		this.description = description;

	}
}