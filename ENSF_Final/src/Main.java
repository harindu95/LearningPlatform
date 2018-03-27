
public class Main {
	public static void main(String[] args) {
		Professors profs = new Professors();
		Courses courses = new Courses();
		Students students = new Students();
		Assignments assignmemts = new Assignments();
		DatabaseManager db = new DatabaseManager(courses, students, profs, assignmemts);
		db.readData();
		for(Student s : students.students.values()) {
			System.out.println(s.firstName + " " + s.courses.size());
		}
		db.close();
	}
}
