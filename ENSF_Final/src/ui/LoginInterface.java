package ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginInterface extends JFrame{
	
	public LoginInterface() {
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		setSize(300,200);
		FlowLayout f = new FlowLayout(FlowLayout.CENTER, 10, 20);
		panel.setLayout(f); 
		JLabel lblUserName = new JLabel("User name");
		JTextField username = new JTextField(15);
		JLabel lblPassword = new JLabel("Password");
		JPasswordField password = new JPasswordField(15);
		password.setEchoChar('*');
		panel.add(lblUserName);
		panel.add(username);
		panel.add(lblPassword);
		panel.add(password);
		
	}
	
	public static void main(String[] args) {
		JFrame f = new LoginInterface();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
