import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Courses {
	Map<Integer,Course> courses;
	DatabaseManager db;
	Courses(){
		courses = new HashMap<>();
	}
	Course getCourse(int id){
		Course c = courses.get(id);
		if(c == null) {
			c = new Course(id);
			courses.put(id, c );
		}
		return c;
	}
	public void setDBManager(DatabaseManager mgr) {
		this.db = mgr;
	}
	
}