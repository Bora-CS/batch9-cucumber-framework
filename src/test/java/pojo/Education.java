package pojo;

public class Education {

	public String school;
	public String degree;
	public String fieldofstudy;
	public String from;
	public String to;
	public boolean current;
	public String description;

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

	public boolean equals(Education education) {
		return (this.school.equals(education.school) && this.degree.equals(education.degree)
				&& this.fieldofstudy.equals(education.fieldofstudy) && this.current == education.current
				&& this.description.equals(education.description));
	}

	public String toString() {
		return "school: " + this.school + "\n" + "degree: " + this.degree + "\n" + "fieldofstudy: " + this.fieldofstudy
				+ "\n" + "from: " + this.from + "\n" + "to: " + this.to + "\n" + "current: " + this.current + "\n"
				+ "description: " + this.description;
	}

}
