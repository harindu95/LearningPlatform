package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import shared.Assignment;
import shared.Course;
import shared.LoginInfo;
import shared.Professor;
import shared.Request;
import shared.Request.DataType;
import shared.Request.Type;
import shared.Student;
import shared.User;

public class Worker implements Runnable {

	private Socket socket;
	private Students students;
	private Assignments assignmnets;
	private Professors profs;
	private Courses courses;
	private FileManager fileMgr;
	private EmailManager emailMgr;
	private DatabaseManager db;
	private Submissions submissions;

	Worker(Socket s, Students students, Professors profs, Courses courses, Assignments assignmnets,Submissions sub, FileManager fileMgr,
			EmailManager emailMgr, DatabaseManager db) {
		socket = s;
		this.students = students;
		this.profs = profs;
		this.assignmnets = assignmnets;
		this.courses = courses;
		this.fileMgr = fileMgr;
		this.emailMgr = emailMgr;
		this.db = db;
		this.submissions = sub;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			while (true) {
				Request req = (Request) in.readObject();
				System.out.println("Handling request...");
				handleRequest(req, out, in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void handleRequest(Request req, ObjectOutputStream out, ObjectInputStream in)
			throws IOException, ClassNotFoundException {
		if (req.type == Type.UPDATE) {
			switch (req.dataType) {
			case Course:
				Course k = courses.addCourse((Course) req.data);
				break;
			case Assignment:
				assignmnets.addAssignment((Assignment)req.data);
				break;
			case ENROLL:
				int[] data = (int[])req.data;
				System.out.println("Updating enrollment");
				db.updateEnrollment(data[0],data[1],true);
				db.readData();
				break;
			case UNROLL:
				int[] data1 = (int[])req.data;
				System.out.println("Updating enrollment");
				db.updateEnrollment(data1[0],data1[1],false);
				db.readData();
				break;
			default:
				System.out.println("Default put");
				break;
			}
			out.flush();
		
		} else if (req.type == Type.GET) {
			switch (req.dataType) {
			case User:
				User k = (User)req.data;
				User u2 = db.authenticate(k.getEmail(), k.getPassword());
				out.writeObject(u2);
				break;
			case StudentList:
				out.writeObject(new ArrayList<Student>(students.students.values()));
				break;
			case SubmissionList:
				out.writeObject(submissions.getSubmissions((Assignment) req.data));
				break;
			case Student:
				out.writeObject(students.students.get(req.id));
				break;
			case Professor:
				out.writeObject(profs.getProfessors().get(req.id));
				break;
			case Assignment:
				out.writeObject(assignmnets.assignments.get(req.id));
				break;
			case Course:
				out.writeObject(courses.courses.get(req.id));
				break;
			case Login:
				LoginInfo info = (LoginInfo) req.data;
				System.out.println("Authentication...");
				User u = db.authenticate(info.username, info.password);
				out.writeObject(u);
				break;
			default:
				System.out.println("Default case::::");
				break;
			}

		}else if(req.type == Type.DELETE) {
			switch(req.dataType) {
			case Course:
				courses.removeCourse((Course)req.data);
				break;
			case Assignment:
				assignmnets.removeAssignment((Assignment)req.data);
				break;
			default:
				System.out.println("Default case::::");
				break;
			}
		}
		out.flush();
	}

}
