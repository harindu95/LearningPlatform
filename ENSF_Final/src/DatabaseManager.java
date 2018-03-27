import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseManager {

	private Courses courses;
	private Students students;
	private Professors professors;

	public Connection jdbc_connection;
	public PreparedStatement statement;
	public String databaseName = "ESNF_Final";
	public String connectionInfo = "jdbc:mysql://localhost:3306/ENSF_Final", login = "ensf", password = null;
	private Assignments assignments;

	public DatabaseManager(Courses courses, Students students, Professors profs, Assignments a) {
		this.courses = courses;
		this.students = students;
		this.professors = profs;
		this.assignments = a;
		courses.setDBManager(this);
		professors.setDBManager(this);
		students.setDBManager(this);

		try {
			// If this throws an error, make sure you have added the mySQL connector JAR to
			// the project
			Class.forName("com.mysql.jdbc.Driver");
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void readData() {
		readCourses();
		readUsers();
		readCourseRegistrations();
		readAssignments();
		readGrades();
		readSubmissions();
	}

	void readCourses() {
		String sql = "SELECT * FROM Courses";
		ResultSet course;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			course = statement.executeQuery();
			while (course.next()) {
				Course c = courses.getCourse(course.getInt("id"));
				c.isActive = course.getBoolean("active");
				c.professor = professors.getProfessor(course.getInt("prof_id"));
				c.professor.courses.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	void readAssignments() {
		String sql = "SELECT * FROM Assignments";
		ResultSet r;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			r = statement.executeQuery();
			while (r.next()) {
				Assignment a = assignments.getAssignment(r.getInt("id"));
				a.active = r.getBoolean("active");
				a.title = r.getString("title");
				a.path = r.getString("path");
				a.due_date = r.getString("due_date");
				Course c = courses.getCourse(r.getInt("course_id"));
				c.assignments.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	void readGrades() {
		String sql = "SELECT * FROM Grades";
		ResultSet r;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			r = statement.executeQuery();
			while (r.next()) {
				Assignment a = assignments.getAssignment(r.getInt("assign_id"));
				Student s = students.getStudent(r.getInt("student_id"));
				Grade grade = new Grade();
				grade.assignment = a;
				grade.grade = r.getInt("assigment_grade");
				s.grades.add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void readSubmissions(){
		String sql = "SELECT * FROM Submissions";
		ResultSet r;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			r = statement.executeQuery();
			while (r.next()) {
				Submission s = new Submission();
				s.assignment = assignments.getAssignment(r.getInt("assign_id"));
				s.title = r.getString("title");
				s.path = r.getString("path");
				s.timeStamp = r.getString("timestamp");
				s.submission_grade = r.getInt("submission_grade");
				Student student = students.getStudent(r.getInt("student_id"));
				student.submissions.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void readUsers() {
		String sql = "SELECT * FROM Users";
		ResultSet user;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			user = statement.executeQuery();
			while (user.next()) {
				User u = new User(user.getInt("id"));
				u.firstName = user.getString("firstname");
				u.lastName = user.getString("lastname");
				u.password = user.getString("password");
				u.email = user.getString("email");
				char type = user.getString("type").charAt(0);
				if(type == 'P') {
					professors.addProfessor(u);
				}else if(type == 'S') {
					students.addStudent(u);
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	void readCourseRegistrations() {
		String sql = "SELECT * FROM StudentEnrollment";
		ResultSet regs;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			regs = statement.executeQuery();
			while (regs.next()) {
				Course c = courses.getCourse(regs.getInt("course_id"));
				Student s = students.getStudent(regs.getInt("student_id"));
				c.students.add(s);
				s.courses.add(c);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			jdbc_connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
