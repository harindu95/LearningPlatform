package shared;
import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
	private List<Course> courses;
	
	public Professor(int id){
		super(id);
		setCourses(new ArrayList<>());
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}