package frontend;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import shared.Assignment;
import shared.Course;
import shared.LoginInfo;
import shared.Professor;
import shared.Request;
import shared.Request.DataType;
import shared.Request.Type;
import shared.Student;
import shared.User;

public class Client {
	Socket aSocket;
	String ID;
	String password;
	Login login;
	GUI gui;
	User user;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public Client(String serverName, int portNumber) {
		try {
			aSocket = new Socket(serverName, portNumber);
			this.out = new ObjectOutputStream(aSocket.getOutputStream());
			out.flush();
			this.in = new ObjectInputStream(aSocket.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User authenticate(String username, String password) throws IOException, ClassNotFoundException {
		Request req = new Request();
		req.dataType = DataType.Login;
		req.type = Type.GET;
		req.data = new LoginInfo(username, password);
		out.writeObject(req);
		out.flush();
		user = (User) in.readObject();
		return user;

	}

	public List<Student> getAllStudents() throws ClassNotFoundException, IOException {
		Request req = new Request();
		req.type = Type.GET;
		req.dataType = DataType.StudentList;
		out.writeObject(req);
		System.out.println("Send request for all students");
		out.flush();
		List<Student> students = (List<Student>) in.readObject();
		System.out.println("got all students");
		return students;
	}

	/**
	 * Close all streams when done
	 */
	private void close() {
		try {
			aSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client c = new Client("localhost", 9090);
					Login window = new Login(c);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Course addCourse(Course c) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Request req = new Request();
		req.type = Type.UPDATE;
		req.dataType = DataType.Course;
		req.data = c;
		out.writeObject(req);
		out.flush();
		Course k = (Course) in.readObject();
		return k;
	}

	public void removeCourse(Course course) throws IOException {
		// TODO Auto-generated method stub
		Request req = new Request();
		req.type = Type.DELETE;
		req.dataType = DataType.Course;
		req.data = course;
		out.writeObject(req);
		out.flush();
	}

	public List<Assignment> updateAssignment(Assignment assign) throws ClassNotFoundException, IOException {
		Request req = new Request();
		req.type = Type.UPDATE;
		req.dataType = DataType.Assignment;
		req.data = assign;
		out.writeObject(req);
		out.flush();
		assign.getCourse().assignments.add(assign);
		return assign.getCourse().assignments;
	}

	public Course updateEnrollment(Course course, Student s, boolean enroll)
			throws IOException, ClassNotFoundException {
		Request req = new Request();
		req.type = Type.UPDATE;
		if (enroll)
			req.dataType = DataType.ENROLL;
		else
			req.dataType = DataType.UNROLL;
		req.data = new int[] { s.id, course.getId() };
		out.writeObject(req);
		out.flush();
		Course k = (Course) in.readObject();

		return k;
	}

	public List<Course> getCourses() throws ClassNotFoundException, IOException {
		User u = authenticate(user.getEmail(), user.getPassword());
		return u.getCourses();
	}

	public void removeAssignment(Assignment a) throws IOException {
		Request req = new Request();
		req.type = Type.DELETE;
		req.dataType = DataType.Assignment;
		req.data = a;
		out.writeObject(req);
		out.flush();

	}

}
