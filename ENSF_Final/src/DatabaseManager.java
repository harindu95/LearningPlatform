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

	public DatabaseManager(Courses courses, Students students, Professors profs) {
		this.courses = courses;
		this.students = students;
		this.professors = profs;

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

	void readCourses() {
		String sql = "SELECT * FROM Courses";
		ResultSet course;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			course = statement.executeQuery();
			while (course.next()) {
				Course c = courses.getCourse(course.getInt("ID"));
				c.isActive = course.getBoolean("Active");
				c.professor = professors.getProfessor(course.getInt("ProfessorID"));
				c.professor.courses.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	void readStudents() {
		String sql = "SELECT * FROM Students";
		ResultSet student;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			student = statement.executeQuery();
			while (student.next()) {
				Student s = students.getStudent(student.getInt("ID"));
				s.firstName = student.getString("FirstName");
				s.lastName = student.getString("LastName");
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	void readProfessors() {
		String sql = "SELECT * FROM Professors";
		ResultSet profs;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			profs = statement.executeQuery();
			while (profs.next()) {
				Professor p = professors.getProfessor(profs.getInt("ID"));
				p.firstName = profs.getString("FirstName");
				p.lastName = profs.getString("LastName");
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	void readCourseRegistrations() {
		String sql = "SELECT * FROM CourseRegistrations";
		ResultSet regs;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			regs = statement.executeQuery();
			while (regs.next()) {
				Course c  = courses.getCourse(regs.getInt("CourseID"));
				Student s = students.getStudent(regs.getInt("StudentID"));
				c.students.add(s);
				s.courses.add(c);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
