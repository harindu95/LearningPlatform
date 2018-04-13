package shared;

import java.io.Serializable;

public class Email implements Serializable{
	public String from = "";
	public String subject = "";
	public String content = "";
	public String[] to;
	public String reciever ="";
}
