package pojo;

public class Experience {

	public String company;
	public String title;
	public String location;
	public String from;
	public String to;
	public boolean current;
	public String description;

	public Experience(String company, String title, String location, String from, String to, boolean current,
			String description) {
		this.company = company;
		this.title = title;
		this.location = location;
		this.from = from;
		this.to = to;
		this.current = current;
		this.description = description;
	}

}
