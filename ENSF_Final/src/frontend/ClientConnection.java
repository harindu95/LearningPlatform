package frontend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import shared.Request;

public class ClientConnection extends Thread
{

	Client client;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	public ClientConnection(Client client) throws IOException
	{
		in = new ObjectInputStream(client.aSocket.getInputStream());
		out = new ObjectOutputStream(client.aSocket.getOutputStream());
		this.client = client;
	}
	
	public void run()
	{}
	
	public void listenForUserRequest(GUI gui)
	{
		try{
			boolean running = true;
			while(running)
			{
				Request request = gui.choices();
				out.writeObject(request);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Used for chat room
	public void listenForServerResponse()
	{
		try{
			boolean running = true;
			while(running)
			{
				

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
