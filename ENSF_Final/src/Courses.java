import java.util.List;
import java.util.Map;

public class Courses {
	Map<Integer,Course> courses;
	
	Course getCourse(int id){
		Course c = courses.get(id);
		if(c == null) {
			courses.put(id, new Course(id));
		}
		return c;
	}
	
}