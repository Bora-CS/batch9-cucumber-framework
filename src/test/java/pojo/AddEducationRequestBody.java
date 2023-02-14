package pojo;
/*
 * @Author: Subhinur.Muhammad
 */
public class AddEducationRequestBody {
	
	public String school; 
	public String degree; 
	public String fieldofstudy;
	public String from; 
	public String to; 
	public String description; 
	
	public AddEducationRequestBody(String school, String degree, String fieldofstudy, String from, String to, String description) {
		this.school = school; 
		this.degree = degree; 
		this.fieldofstudy = fieldofstudy; 
		this.from = from; 
		this.to = to; 
		this.description = description; 
	}
	

}
