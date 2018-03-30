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

	Worker(Socket s) {
		socket = s;
		students = new Students();
		courses = new Courses();
		assignmnets = new Assignments();
		profs = new Professors();
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
