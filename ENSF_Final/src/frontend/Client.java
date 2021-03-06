package frontend;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.UIManager;

import shared.Assignment;
import shared.Course;
import shared.LoginInfo;
import shared.Request;
import shared.Request.DataType;
import shared.Request.Type;
import shared.Student;
import shared.Submission;
import shared.User;

public class Client {
	Socket aSocket;
	String ID;
	GUI gui;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private State state;

	public Client(State s, String serverName, int portNumber) {
		this.state = s;
		try {
			aSocket = new Socket(serverName, portNumber);
			this.out = new ObjectOutputStream(aSocket.getOutputStream());
			out.flush();
			this.in = new ObjectInputStream(aSocket.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() throws IOException, ClassNotFoundException {
		Request req = new Request();
		req.dataType = DataType.User;
		req.type = Type.GET;
		req.data = state.user;
		out.writeObject(req);
		out.flush();
		state.user = (User) in.readObject();
		state.students = getAllStudents();
	}
	public void authenticate(String username, String password) throws IOException, ClassNotFoundException {
		Request req = new Request();
		req.dataType = DataType.Login;
		req.type = Type.GET;
		req.data = new LoginInfo(username, password);
		out.writeObject(req);
		out.flush();
		state.user = (User) in.readObject();
	}

	public List<Student> getAllStudents() throws ClassNotFoundException, IOException {
		Request req = new Request();
		req.type = Type.GET;
		req.dataType = DataType.StudentList;
		out.writeObject(req);
		System.out.println("Send request for all students");
		out.flush();
		state.students = (List<Student>) in.readObject();
		return state.students;
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


	public void addCourse(Course c) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Request req = new Request();
		req.type = Type.UPDATE;
		req.dataType = DataType.Course;
		req.data = c;
		out.writeObject(req);
		out.flush();
		update();
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
		update();
		assign.getCourse().assignments.add(assign);
		return state.getCourse(assign.getCourse().getId()).assignments;
	}

	public void updateEnrollment(Course course, Student s, boolean enroll)
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
		update();
	}

	public List<Course> getCourses() throws ClassNotFoundException, IOException {
		return state.user.getCourses();
	}

	public void removeAssignment(Assignment a) throws IOException {
		Request req = new Request();
		req.type = Type.DELETE;
		req.dataType = DataType.Assignment;
		req.data = a;
		out.writeObject(req);
		out.flush();
	}
	
	public List<Submission> getSubmissions(Assignment a) throws IOException, ClassNotFoundException{
		Request req = new Request();
		req.type = Type.GET;
		req.dataType = DataType.SubmissionList;
		req.data = a;
		out.writeObject(req);
		out.flush();
		return (List<Submission>)in.readObject();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					State s = new State();
					Client c = new Client(s,"localhost", 9090);
					Login window = new Login(c, s);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
