package pojo;

public class ExperienceRequestBody {

	public String company;
	public String title;
	public String location;
	public String from;
	public String to;
	public String description;

	public ExperienceRequestBody(String company, String title, String location, String from, String to,
			String description) {
		this.company = company;
		this.title = title;
		this.location = location;
		this.from = from;
		this.to = to;
		this.description = description;
	}

}
