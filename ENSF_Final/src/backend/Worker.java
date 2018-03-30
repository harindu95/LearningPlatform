package backend;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import shared.MSG_TYPE;
import shared.Request;
import shared.Request.DataType;
import shared.Request.Type;

public class Worker implements Runnable {

	private Socket socket;
	private Students students;
	private Assignments assignmnets;
	private Professors profs;
	private Courses courses;
	private FileManager fileMgr;
	private EmailManager emailMgr;

	Worker(Socket s, Students students, Professors profs, Courses courses, Assignments assignmnets, FileManager fileMgr, EmailManager emailMgr) {
		socket = s;
		this.students = students;
		this.profs = profs;
		this.assignmnets = assignmnets;
		this.courses = courses;
		this.fileMgr = fileMgr;
		this.emailMgr = emailMgr;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			while (true) {
				if (in.available() > 0) {
					Request req = (Request) in.readObject();
					handleRequest(req, out);
				}
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

	private void handleRequest(Request req, ObjectOutputStream out) throws IOException {
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
				out.writeObject(profs.professors.get(req.id));
				break;
			case Assignment:
				out.writeObject(assignmnets.assignments.get(req.id));
				break;
			case Course:
				out.writeObject(courses.courses.get(req.id));
				break;
			default:
				break;
			}

		}
		out.flush();
	}

}
