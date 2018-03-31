package frontend;

public class User 
{
	Login login;
	String ID;
	String password;
	GUI gui;
	Client client;
	@SuppressWarnings("deprecation")
	public User()
	{
		login = new Login();
		while(!login.loginPressed)
		{
			ID = login.username.getText();
			password = login.password.getText();
		}
		client = new Client("localhost", 9018, gui);
		client.setID(ID);
		client.setPassword(password);
		client.communicate();
	}
}
