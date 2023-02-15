package pojo;

public class EducationRequestBody {

	public String school;
	public String degree;
	public String fieldofstudy;
	public String from;
	public String to;
	public boolean current;
	public String description;
	
	
	public EducationRequestBody(String school, String degree, String fieldofstudy, String from, String to, String description, boolean current ) {
		this.school = school;
		this.degree = degree;
		this.fieldofstudy = fieldofstudy;
		this.from = from;
		this.to = to;
		this.description = description;
		this.current = current;
	}
	
	

}
