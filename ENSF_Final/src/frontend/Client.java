package frontend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
	Socket aSocket;
	
	public Client(String serverName, int portNumber) 
	{
		try {
			aSocket = new Socket(serverName, portNumber);
			
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * Communicate with the server using ClientConnection class
	 */
	public void communicate() {
		try{
			ClientConnection clientConnection = new ClientConnection(this);
			clientConnection.start();
			clientConnection.listenForUserRequest();
			clientConnection.listenForServerResponse();
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
