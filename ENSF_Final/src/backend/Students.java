package backend;
import java.util.HashMap;
import java.util.Map;

import shared.Student;
import shared.User;

public class Students {
	public Map<Integer, Student> students;  // list of students
	DatabaseManager db; // a database manager to manage the database

	public Students() {
		students = new HashMap<>(); // list f students initialized
	}

	//searchs the student by id and returns it if the student is not there then make new student and put that student inside student list and return the newly created student.
	public Student getStudent(int id) {
		Student s = students.get(id); 
		if (s == null) {
			s = new Student(id);
			students.put(id, s);
		}
		return s;
	}

	public void setDBManager(DatabaseManager mgr) {
		this.db = mgr;
	}

	
	public void addStudent(User u) {
		Student s = getStudent(u.id);
		s.setEmail(u.getEmail());
		s.setFirstName(u.getFirstName());
		s.setLastName(u.getLastName());
		s.setPassword(u.getPassword());
	}
	
	
}
