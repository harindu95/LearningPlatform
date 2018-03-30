package shared;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3262837326765539465L;
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
