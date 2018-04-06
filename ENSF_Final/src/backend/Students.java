package backend;
import java.util.HashMap;
import java.util.Map;

import shared.Student;
import shared.User;

public class Students {
	public Map<Integer, Student> students;
	DatabaseManager db;

	public Students() {
		students = new HashMap<>();
	}

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
