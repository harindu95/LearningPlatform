package backend;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.Course;

public class Courses {
	Map<Integer,Course> courses;
	DatabaseManager db;
	public Courses(){
		courses = new HashMap<>();
	}
	
	public Course getCourse(int id){
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

	public Course addCourse(Course data) {
		System.out.println("updating database: adding a course" + data.getName());
		int id = db.addCourse(data);
		db.readData();
		return courses.get(id);
	}

	public void removeCourse(Course data) {
		System.out.println("updating database: removing a course " + data.getName());
		db.deleteCourse(data);
		db.readData();
	}
	
}