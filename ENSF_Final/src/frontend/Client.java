package frontend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import shared.Request;
import shared.Request.DataType;
public class Client
{
	Socket aSocket;
	String ID;
	String password;
	Login login;
	GUI gui;
	@SuppressWarnings("deprecation")
	public Client(String serverName, int portNumber) 
	{
		try 
		{
			aSocket = new Socket(serverName, portNumber);
			this.login = new Login();
			while(!login.loginPressed)
			{
				ID = login.username.getText();
				password = login.password.getText();
			}
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
			Request res = clientConnection.checkValidUser(ID, password);
			if(res.isValid)
			{
				if(res.dataType == DataType.Professor)
				{
					gui = new ProfGUI();
				}
				else if(res.dataType == DataType.Student)
				{
					gui = new StudentGUI();
				}
				clientConnection.listenForUserRequest(gui);
				clientConnection.listenForServerResponse();
			}
			else
			{
				login.displayMessage("Invalid UserName or Password! Please try again.");
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
