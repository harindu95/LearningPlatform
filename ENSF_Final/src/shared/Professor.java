package shared;
import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
	public List<Course> courses;
	
	public Professor(int id){
		super(id);
		courses = new ArrayList<>();
	}
}
