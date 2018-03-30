package backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import shared.Assignment;
import shared.Course;
import shared.Grade;
import shared.Professor;
import shared.Student;
import shared.Submission;
import shared.User;

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

	public void readData() {
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
				c.setActive(course.getBoolean("active"));
				c.setName(course.getString("name"));
				c.setProfessor(professors.getProfessor(course.getInt("prof_id")));
				c.getProfessor().getCourses().add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	void updateAssignment(Assignment a,Course c) {
		String sql ="UPDATE Assignments SET active=?, title=?, path=?, due_date=?,course_id=?, WHERE id=?";
		
		try {
			statement = jdbc_connection.prepareStatement(sql);
			statement.setBoolean(1,a.isActive());
			statement.setString(2,a.getTitle());
			statement.setString(3, a.getPath());
			statement.setString(4,a.getDue_date());
			statement.setInt(5, c.getId());
			statement.setInt(6, a.getId());
			statement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void updateUser(User u) {
				
		 String sql = "UPDATE Users SET password=?, email=?, firstname=?, lastname=?, type=? WHERE id=?";
			
			try {
				statement = jdbc_connection.prepareStatement(sql);
				statement.setString(1, u.getPassword());
				statement.setString(2,u.getEmail());
				statement.setString(3, u.getFirstName());
				statement.setString(4, u.getLastName());
				char type = ' ';
				if (u instanceof Student) {
					type = 'S';
				}else if(u instanceof Professor) {
					type = 'P';
				}
				statement.setString(5, "" +type);
				statement.setInt(6,u.id);
				statement.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	void updateCourse(Course c) {
		String sql ="UPDATE Courses SET active=?, prof_id=?, name=?, WHERE id=?";
		
		try {
			statement = jdbc_connection.prepareStatement(sql);
			statement.setBoolean(1,c.isActive());
			statement.setInt(2,c.getProfessor().id);
			statement.setString(3, c.getName());
			statement.setInt(4, c.getId());
			statement.executeQuery();
			
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
				a.setActive(r.getBoolean("active"));
				a.setTitle(r.getString("title"));
				a.setPath(r.getString("path"));
				a.setDue_date(r.getString("due_date"));
				Course c = courses.getCourse(r.getInt("course_id"));
				c.assignments.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	void updateGrades(Grade g,Student s) {
		String sql ="UPDATE Grades SET assign_id=?, assignment_grade=?,student_id=? WHERE id=?";
		
		try {
			statement = jdbc_connection.prepareStatement(sql);
			statement.setInt(1,g.getAssignment().getId());
			statement.setInt(2,g.getGrade());
			statement.setInt(3, s.id);
			statement.setInt(3, g.getId());
			statement.executeQuery();
			
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
				Grade grade = new Grade(r.getInt("id"));
				grade.setAssignment(a);
				grade.setGrade(r.getInt("assigment_grade"));
				s.getGrades().add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void readSubmissions() {
		String sql = "SELECT * FROM Submissions";
		ResultSet r;
		try {
			statement = jdbc_connection.prepareStatement(sql);
			r = statement.executeQuery();
			while (r.next()) {
				Submission s = new Submission();
				s.setAssignment(assignments.getAssignment(r.getInt("assign_id")));
				s.setTitle(r.getString("title"));
				s.setPath(r.getString("path"));
				s.setTimeStamp(r.getString("timestamp"));
				s.setSubmission_grade(r.getInt("submission_grade"));
				Student student = students.getStudent(r.getInt("student_id"));
				student.getSubmissions().add(s);
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
				u.setFirstName(user.getString("firstname"));
				u.setLastName(user.getString("lastname"));
				u.setPassword(user.getString("password"));
				u.setEmail(user.getString("email"));
				char type = user.getString("type").charAt(0);
				if (type == 'P') {
					professors.addProfessor(u);
				} else if (type == 'S') {
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
				
				c.getStudents().add(s);
				s.getCourses().add(c);

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

	/**
	 * Use the jdbc connection to create a new database in MySQL. (e.g. if you are
	 * connected to "jdbc:mysql://localhost:3306", the database will be created at
	 */
	public void createDB() {
		try {
			statement = jdbc_connection.prepareStatement("CREATE DATABASE " + databaseName);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a data table inside of the database to hold clients
	 */
	public void createTables() {
		String sqlUsers = "CREATE TABLE `Users` ( `id` int(8) NOT NULL AUTO_INCREMENT,"
				+ " `password` varchar(20) NOT NULL," + " `email` varchar(50) NOT NULL,"
				+ " `firstname` varchar(30) NOT NULL," + "`lastname` varchar(30) NOT NULL,"
				+ " `type` char(1) NOT NULL," + " PRIMARY KEY (`id`))";

		String sqlCourses = "CREATE TABLE `Courses` (\n" + " `id` int(8) NOT NULL AUTO_INCREMENT,\n"
				+ " `prof_id` int(8) NOT NULL,\n" + " `name` varchar(50) NOT NULL,\n" + " `active` bit(1) NOT NULL,\n"
				+ " PRIMARY KEY (`id`),\n" + " KEY `prof_id` (`prof_id`),\n"
				+ " CONSTRAINT `Courses_ibfk_1` FOREIGN KEY (`prof_id`) REFERENCES `Users` (`id`)\n" + ")";

		String sqlStudentEnrollment = "CREATE TABLE `StudentEnrollment` (\n" + " `id` int(8) NOT NULL AUTO_INCREMENT,\n"
				+ " `student_id` int(8) NOT NULL,\n" + " `course_id` int(8) NOT NULL,\n" + " PRIMARY KEY (`id`),\n"
				+ " KEY `student_id` (`student_id`),\n" + " KEY `course_id` (`course_id`),\n"
				+ " CONSTRAINT `StudentEnrollment_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `Users` (`id`),\n"
				+ " CONSTRAINT `StudentEnrollment_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `Courses` (`id`)\n"
				+ ") ";
		String sqlAssignments = "CREATE TABLE `Assignments` (\n" + " `id` int(8) NOT NULL AUTO_INCREMENT,\n"
				+ " `course_id` int(8) NOT NULL,\n" + " `title` varchar(50) NOT NULL,\n"
				+ " `path` varchar(100) NOT NULL,\n" + " `active` bit(1) NOT NULL,\n"
				+ " `due_date` char(16) NOT NULL,\n" + " PRIMARY KEY (`id`),\n" + " KEY `course_id` (`course_id`),\n"
				+ " KEY `file_id` (`path`),\n"
				+ " CONSTRAINT `Assignments_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `Courses` (`ID`)\n" + ")";

		String sqlGrades = " 	CREATE TABLE `Grades` (\n" + " `id` int(8) NOT NULL AUTO_INCREMENT,\n"
				+ " `assign_id` int(8) NOT NULL,\n" + " `student_id` int(8) NOT NULL,\n"
				+ " `course_id` int(8) NOT NULL,\n" + " `assigment_grade` int(3) NOT NULL,\n" + " PRIMARY KEY (`id`),\n"
				+ " KEY `assign_id` (`assign_id`),\n" + " KEY `student_id` (`student_id`),\n"
				+ " KEY `course_id` (`course_id`),\n"
				+ " CONSTRAINT `Grades_ibfk_1` FOREIGN KEY (`assign_id`) REFERENCES `Assignments` (`id`),\n"
				+ " CONSTRAINT `Grades_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `Users` (`id`),\n"
				+ " CONSTRAINT `Grades_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `Courses` (`id`)\n" + ")";

		String sqlSubmissions = "CREATE TABLE `Submissions` (\n" + " `id` int(8) NOT NULL AUTO_INCREMENT,\n"
				+ " `assign_id` int(8) NOT NULL,\n" + " `student_id` int(8) NOT NULL,\n"
				+ " `title` varchar(50) NOT NULL,\n" + " `path` varchar(100) NOT NULL,\n"
				+ " `submission_grade` int(3) NOT NULL,\n" + " `comments` varchar(140) NOT NULL,\n"
				+ " `timestamp` char(16) NOT NULL,\n" + " PRIMARY KEY (`id`),\n" + " KEY `assign_id` (`assign_id`),\n"
				+ " KEY `student_id` (`student_id`),\n" + " KEY `file_id` (`path`),\n"
				+ " CONSTRAINT `Submissions_ibfk_1` FOREIGN KEY (`assign_id`) REFERENCES `Assignments` (`id`),\n"
				+ " CONSTRAINT `Submissions_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `Users` (`id`)\n" + ") ";

		try {
			Statement st = jdbc_connection.createStatement();
			st.executeUpdate(sqlUsers);
			st.executeUpdate(sqlCourses);
			st.executeUpdate(sqlStudentEnrollment);
			st.executeUpdate(sqlAssignments);
			st.executeUpdate(sqlGrades);
			st.executeUpdate(sqlSubmissions);
			System.out.println("Created new tables");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeTables() {
		String removeForeignChecks = "SET foreign_key_checks = 0;";
		String sql = "DROP TABLE %s";
		String[] tableNames = {"Users","Courses","Assignments", "StudentEnrollment","Submissions","Grades"};
		try {
			
			Statement st = jdbc_connection.createStatement();
			st.executeUpdate(removeForeignChecks);
			for(String t: tableNames) {
				st.executeUpdate(String.format(sql,t));
			}
			System.out.println("Removed all tables.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fillTables() {
		List<String> queries = new ArrayList<>();
		queries.add(
				"INSERT INTO `Users` (`id`, `password`, `email`, `firstname`, `lastname`, `type`) VALUES (NULL, 'admin', 'abc@university.com', 'F1', 'L1', 'P');");
		queries.add(
				"INSERT INTO `Users` (`id`, `password`, `email`, `firstname`, `lastname`, `type`) VALUES (NULL, 'admin', 'norm@ucalgray.ca', 'Norm', 'Bartley', 'P');");
		queries.add(
				"INSERT INTO `Users` (`id`, `password`, `email`, `firstname`, `lastname`, `type`) VALUES (NULL, 'admin', 'moushirpour@ucalgary.ca', 'M', 'Moushirpour', 'P');");
		queries.add(
				"INSERT INTO `Users` (`id`, `password`, `email`, `firstname`, `lastname`, `type`) VALUES (NULL, 'admin', 'harindudilshan95@gmail.com', 'Kavinda', 'Pitiduwa Gamage', 'S');");
		queries.add(
				"INSERT INTO `Users` (`id`, `password`, `email`, `firstname`, `lastname`, `type`) VALUES (NULL, 'admin', 'abc@gmail.com', 'Cong', 'Pham', 'S');");

		queries.add("INSERT INTO `Courses` (`id`, `prof_id`, `name`, `active`) VALUES (NULL, '2', 'ENCM 369', b'1');");
		queries.add("INSERT INTO `Courses` (`id`, `prof_id`, `name`, `active`) VALUES (NULL, '2', 'ENCM339', b'0');");
		queries.add("INSERT INTO `Courses` (`id`, `prof_id`, `name`, `active`) VALUES (NULL, '3', 'ENSF409', b'1');");

		queries.add("INSERT INTO `StudentEnrollment` (`id`, `student_id`, `course_id`) VALUES (NULL, '4', '1');");
		queries.add("INSERT INTO `StudentEnrollment` (`id`, `student_id`, `course_id`) VALUES (NULL, '4', '3');");
		queries.add("INSERT INTO `StudentEnrollment` (`id`, `student_id`, `course_id`) VALUES (NULL, '5', '1');");
		queries.add("INSERT INTO `StudentEnrollment` (`id`, `student_id`, `course_id`) VALUES (NULL, '5', '3');");
		try {
			Statement st = jdbc_connection.createStatement();
			for (String sql : queries) {
				st.executeUpdate(sql);
			}

			System.out.println("Filled tables with data");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
