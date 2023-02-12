package pojo;

public class Education {
	public boolean current;
	public String _id;
	public String school;
	public String degree;
	public String fieldofstudy;
	public String from;
	public String to;
	public String description;

	public Education() {

	}

	public Education(String school, String degree, String fieldofstudy, String from, String to, boolean current,
			String description) {
		this.school = school;
		this.degree = degree;
		this.fieldofstudy = fieldofstudy;
		this.from = from;
		this.to = to;
		this.current = current;
		this.description = description;
	}

}
