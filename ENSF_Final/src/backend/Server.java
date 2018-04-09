package backend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private int numThreads = 20;
	private ExecutorService executor;
	private ServerSocket sSocket;

	public Server(int port) throws IOException {
		sSocket = new ServerSocket(port);
		executor = Executors.newFixedThreadPool(numThreads);
		System.out.println("Server started...");
	}

	public void listen() {
		try {
			FileManager fileMgr = new FileManager();
			EmailManager emailMgr = new EmailManager();
			Students students = new Students();
			Professors profs = new Professors();
			Assignments assignmnets = new Assignments();
			Courses courses = new Courses();
			Submissions subs = new Submissions();
			DatabaseManager db = new DatabaseManager(courses, students, profs, assignmnets,subs);
			db.readData();
			while (true) {
				Socket s = sSocket.accept();
				executor.execute(new Worker(s, students, profs, courses, assignmnets, subs, fileMgr, emailMgr, db));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sSocket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("Server stopped..");
		}

	}

	public static void main(String[] args) {
		try {
			Server s = new Server(9090);
			s.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
