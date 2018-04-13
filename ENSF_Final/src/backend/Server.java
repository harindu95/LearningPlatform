package backend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	private int numThreads = 20; //allowed threads in threadpool
	private ExecutorService executor;
	private ServerSocket sSocket;
	
	//starting the server with port 9090 and creating a threadpool to manage multiple threads
	public Server(int port) throws IOException {
		sSocket = new ServerSocket(port); 
		executor = Executors.newFixedThreadPool(numThreads);
		System.out.println("Server started...");
	}

	//listening from a client.
	public void listen() {
		try {
			FileManager fileMgr = new FileManager(); // to manage files.
			EmailManager emailMgr = new EmailManager(); // to send emails
			Students students = new Students(); // list of students
			Professors profs = new Professors(); // list of profs
			Assignments assignmnets = new Assignments(); // list of assignments
			Courses courses = new Courses(); // list of courses
			Submissions subs = new Submissions(); // list of submissions
			DatabaseManager db = new DatabaseManager(courses, students, profs, assignmnets,subs);
			db.readData(); //reads data from database
			while (true) { // accepts connections from clients as long as the client want to communicate
				Socket s = sSocket.accept(); 
				executor.execute(new Worker(s, students, profs, courses, assignmnets, subs, fileMgr, emailMgr, db)); // worker to execute the thread in threadpool
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

	// initializing server for connection.
	public static void main(String[] args) {
		try {
			Server s = new Server(9090);
			s.listen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
