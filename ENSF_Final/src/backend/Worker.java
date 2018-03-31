package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import shared.LoginInfo;
import shared.MSG_TYPE;
import shared.Request;
import shared.Request.DataType;
import shared.Request.Type;
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

	Worker(Socket s, Students students, Professors profs, Courses courses, Assignments assignmnets, FileManager fileMgr, EmailManager emailMgr,DatabaseManager db) {
		socket = s;
		this.students = students;
		this.profs = profs;
		this.assignmnets = assignmnets;
		this.courses = courses;
		this.fileMgr = fileMgr;
		this.emailMgr = emailMgr;
		this.db = db;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			while (true) {
					Request req = (Request) in.readObject();
					System.out.println("Handling request...");
					handleRequest(req, out,in);
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

	private void handleRequest(Request req, ObjectOutputStream out, ObjectInputStream in) throws IOException, ClassNotFoundException {
		if (req.type == Type.PUT) {
			if (req.dataType == DataType.Student) {
				// TODO: call db store
			}
		} else if (req.type == Type.GET) {
			switch (req.dataType) {
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
				LoginInfo info = (LoginInfo)req.data;
				System.out.println("Authentication...");
				User u = db.authenticate(info.username, info.password);
				out.writeObject(u);
				break;
			default:
				System.out.println("Default case::::");
				break;
			}

		}
		out.flush();
	}

}
