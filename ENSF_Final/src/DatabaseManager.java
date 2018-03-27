
public class DatabaseManager {

	private Courses courses;
	private Students students;
	private Professors professors;

	public DatabaseManager(Courses courses, Students students, Professors profs) {
		this.courses = courses;
		this.students = students;
		this.professors = profs;
	}
	
	void readCourses() {
		int id = 0;
		Course c = courses.getCourse(id);
	}
}
