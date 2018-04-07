import backend.Assignments;
import backend.Courses;
import backend.DatabaseManager;
import backend.Professors;
import backend.Students;
import backend.Submissions;
import shared.Student;

public class Main {
	public static void main(String[] args) {
		Professors profs = new Professors();
		Courses courses = new Courses();
		Students students = new Students();
		Assignments assignmemts = new Assignments();
		Submissions subs = new Submissions();
		DatabaseManager db = new DatabaseManager(courses, students, profs, assignmemts,subs);
//		db.createDB();
		db.createTables();
		db.fillTables();
//		db.readData();
		for(Student s : students.students.values()) {
			System.out.println(s.getFirstName() + " " + s.getCourses().size());
		}
//		db.removeTables();
		db.close();
	}
}
