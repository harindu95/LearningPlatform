package frontend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
	Socket aSocket;
	String ID;
	String password;
	GUI gui;
	public Client(String serverName, int portNumber, GUI gui) 
	{
		try 
		{
			aSocket = new Socket(serverName, portNumber);
			this.gui = gui;
		} 
		catch (IOException e) 
		{
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * Communicate with the server using ClientConnection class
	 */
	public void communicate() 
	{
		try
		{
			ClientConnection clientConnection = new ClientConnection(this);
			clientConnection.start();
			if(clientConnection.checkValidUser(ID, password))
			{
				clientConnection.listenForUserRequest(gui);
				clientConnection.listenForServerResponse();
			}
			else
			{
				gui.displayMessage("Invalid UserName or Password! Please try again.");
			}
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

    public void setID(String ID)
    {
    	this.ID = ID;
    }
    
    public void setPassword(String Password)
    {
    	this.password = Password;
    }

}
