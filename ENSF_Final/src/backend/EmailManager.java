package backend;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import shared.Email;

public class EmailManager {

	private Session session;
	private final String address = "ensf409@gmail.com";
	private final String password = "ensf409winter";

	public EmailManager() {
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true"); // Using TLS
		properties.put("mail.smtp.auth", "true"); // Authenticate
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Using Gmail Account
		properties.put("mail.smtp.port", "587"); // TLS uses port 587
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(address, password);
			}
		});
	}

	void sendEmail(Email mail) {

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(address));
//			for (String s : mail.to) {
//				message.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
//			}
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("harindudilshan95@gmail.com"));
			message.setSubject(mail.subject);
			String msg = String.format("FROM: %s\n" + "TO: %s\n" + "SUBJECT: %s\n\n" + "%s", mail.from, mail.reciever,
					mail.subject, mail.content);
			message.setText(msg);
			Transport.send(message); // Send the EmailMessage
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
