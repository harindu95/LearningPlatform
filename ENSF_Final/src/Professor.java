import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
	List<Course> courses;
	
	Professor(int id){
		super(id);
		courses = new ArrayList<>();
	}
}
