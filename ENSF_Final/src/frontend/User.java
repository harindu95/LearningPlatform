package frontend;

public class User 
{
	String ID;
	String password;
	Client client;

	public User()
	{
		client = new Client("localhost", 9018);
		client.communicate();
	}
}
