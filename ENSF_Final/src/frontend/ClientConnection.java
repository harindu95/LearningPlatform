import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientConnection extends Thread
{

	Client client;
	PrintWriter SocketOut;
	BufferedReader SocketIn;
	
	public ClientConnection(PrintWriter socketOut, BufferedReader socketIn, Client client)
	{
		this.client = client;
		this.SocketOut = socketOut;
		this.SocketIn = socketIn;
	}
	
	public void run()
	{
		this.responseToServer();
	}
	
	/**
	 * Waiting for the server response then respond back to the server
	 */
	public void responseToServer()
	{
		try{
			boolean running = true;
			while(running)
			{
				String s = SocketIn.readLine();

			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}
