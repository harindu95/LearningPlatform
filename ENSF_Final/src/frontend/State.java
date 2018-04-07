package frontend;

import java.util.List;

import shared.Course;
import shared.Student;

public class State {
	public shared.User user;
	public List<Student> students;
	
	Course getCourse(int courseId) {
		for(int i=0; i<user.getCourses().size();i++) {
			if(user.getCourses().get(i).getId() == courseId) {
				return user.getCourses().get(i);
			}
		}
		return null;
	}
}
