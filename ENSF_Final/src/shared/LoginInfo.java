package shared;

import java.io.Serializable;

public class LoginInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6033621643807832996L;
	public String username = "";
	public String password = "";
	
	public LoginInfo(String user, String pass) {
		username = user;
		password= pass;
	}
}
