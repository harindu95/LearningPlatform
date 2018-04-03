package frontend;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.UIManager;

import shared.LoginInfo;
import shared.Request;
import shared.Request.DataType;
import shared.Request.Type;
import shared.User;

public class Client
{
	Socket aSocket;
	String ID;
	String password;
	Login login;
	GUI gui;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	@SuppressWarnings("deprecation")
	public Client(String serverName, int portNumber) 
	{
		try 
		{
			aSocket = new Socket(serverName, portNumber);
			this.out = new ObjectOutputStream(aSocket.getOutputStream());
			out.flush();
			this.in= new ObjectInputStream(aSocket.getInputStream());
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public User authenticate(String username, String password) throws IOException, ClassNotFoundException {
		Request res = new Request();
		res.dataType = DataType.Login;
		res.type = Type.GET;
		res.data = new LoginInfo(username,password);
		out.writeObject(res);
		out.flush();
		User user = (User)in.readObject();
		return user;
		
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

    public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client c = new Client("localhost",9090);
					Login window = new Login(c);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    	
}
