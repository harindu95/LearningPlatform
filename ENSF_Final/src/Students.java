import java.util.HashMap;
import java.util.Map;

public class Students {
	Map<Integer, Student> students;
	DatabaseManager db;

	Students() {
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
		s.email = u.email;
		s.firstName = u.firstName;
		s.lastName = u.lastName;
		s.password = u.password;
	}
}
