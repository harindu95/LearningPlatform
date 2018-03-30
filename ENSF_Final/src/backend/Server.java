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
	}

	public void listen() {
		try {
			while (true) {
				Socket s = sSocket.accept();
				executor.execute(new Worker(s));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				sSocket.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}

	}
}
