import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Constants{
	private PrintWriter socketOut;
	private Socket aSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;
	
	
	public Client(String serverName, int portNumber) 
	{
		try {
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			//System.out.println("Hello user, please Enter your name: ");
			String name = stdIn.readLine();

			aSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
			socketOut.println(mainPlayer.getName());
			
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * Communicate with the server using ClientConnection class
	 */
	public void communicate() {
		try{
			ClientConnection clientConnection = new ClientConnection(socketOut, socketIn, this);
			clientConnection.start();
		}
		catch(Exception e)
		{	
			e.printStackTrace();
			this.close();
		}
	}
	
    /**
     * Close all streams when done
     */
    private void close()
    {
    	try{
	    	socketOut.close();
	    	socketIn.close();
	    	stdIn.close();
	    	aSocket.close();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
	
	public static void main(String[] args) throws IOException {
		Client aClient = new Client("localhost", 9018);
		aClient.communicate();
	}
}
