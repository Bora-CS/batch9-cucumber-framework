package pojo;

public class CreateEducationRequestBody {
	/*
	 * Class that mimics the adding education request body structure and
	 * constructor that initializes the education parameters
	 * 
	 * Author: Erlyn Gammad
	 */
	public String school;
	public String degree;
	public String fieldofstudy;
	public String from;
	public String to;
	public String description;

	public CreateEducationRequestBody(String school, String degree, String fieldofstudy, String from, String to,
			String description) {
		this.school = school;
		this.degree = degree;
		this.fieldofstudy = fieldofstudy;
		this.from = from;
		this.to = to;
		this.description = description;

	}
}
