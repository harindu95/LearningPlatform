package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JPasswordField;
import javax.swing.UIManager;

import shared.Professor;
import shared.Student;
import shared.User;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	JFrame frame;
	JTextField username;
	JPasswordField password;
	private JLabel loginBtn;
	private JLabel cancelBtn;
	boolean loginPressed = false;
	private Client client;
	private JLabel spinner;

	/**
	 * Create the application.
	 * 
	 * @param c
	 */
	public Login(Client c) {
		this.client = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 617, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		Font font = new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 12);
		username = new JTextField();
		username.setFont(font);
		username.setSelectionColor(new Color(190, 168, 160));

		username.setText("username");
		username.selectAll();

		username.setBackground(new Color(190, 168, 170));
		username.setBorder(null);

		username.setBounds(236, 141, 153, 19);
		frame.getContentPane().add(username);
		username.setColumns(20);

		password = new JPasswordField();
		password.setColumns(20);
		password.setFont(font);
		password.setBorder(null);
		password.setBackground(new Color(190, 168, 170));
		password.setBounds(236, 188, 153, 19);
		frame.getContentPane().add(password);

		loginBtn = new JLabel("");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				loginBtn.setIcon(new ImageIcon("resources/images/loginbtn2.png"));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				loginBtn.setIcon(new ImageIcon("resources/images/loginbtn1.png"));
				loginPressed = true;
			}

		
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
//					User u = client.authenticate(username.getText(), new String(password.getPassword()));
					User u = client.authenticate("norm@ucalgary.ca", "admin");
					login(u);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		loginBtn.setIcon(new ImageIcon(Login.class.getResource("/images/loginbtn1.png")));
		loginBtn.setBounds(236, 228, 147, 33);
		frame.getContentPane().add(loginBtn);

		cancelBtn = new JLabel("");
		cancelBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				cancelBtn.setIcon(new ImageIcon("resources/images/logincancel2.png"));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				cancelBtn.setIcon(new ImageIcon("resources/images/logincancel1.png"));
				username.setText("");
				password.setText("");
			}
		});
		cancelBtn.setIcon(new ImageIcon(Login.class.getResource("/images/logincancel1.png")));
		cancelBtn.setBounds(236, 262, 147, 33);
		frame.getContentPane().add(cancelBtn);

		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(Login.class.getResource("/images/login_page.png")));
		background.setBounds(0, -13, 619, 386);
		frame.getContentPane().add(background);
	}

	public void displayMessage(String Message) {
		JOptionPane.showMessageDialog(null, Message, "Message", JOptionPane.OK_OPTION);
	}

	
	private void login(User u) {
		if (u == null) {
			displayMessage("Login failed!");
		} else {
			if (u instanceof Student) {
				displayMessage("User is a student");
				
			} else if (u instanceof Professor) {

				displayMessage("User is a professor");
				System.out.println("courses : ::" +((Professor) u).getCourses().size());
				ProfGUI window = new ProfGUI(client,(Professor)u);
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		}
	}

//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login window = new Login(null);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
}
