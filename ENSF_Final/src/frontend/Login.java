package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(190, 168, 170));
		textField.setBorder(null);
		
		textField.setBounds(236, 142, 153, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(20);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(20);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(190, 168, 170));
		textField_1.setBounds(236, 189, 153, 19);
		frame.getContentPane().add(textField_1);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				label.setIcon(new ImageIcon("resources/images/loginbtn2.png"));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				label.setIcon(new ImageIcon("resources/images/loginbtn1.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon("resources/images/loginbtn3.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setIcon(new ImageIcon("resources/images/loginbtn1.png"));
			}
			
		});
		label.setIcon(new ImageIcon("resources/images/loginbtn3.png"));
		label.setBounds(236, 229, 147, 33);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				label_1.setIcon(new ImageIcon("resources/images/logincancel2.png"));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				label_1.setIcon(new ImageIcon("resources/images/logincancel1.png"));
				textField.setText("");
				textField_1.setText("");
			}
		});
		label_1.setIcon(new ImageIcon("resources/images/logincancel1.png"));
		label_1.setBounds(236, 263, 147, 33);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("resources/images/login_page.png"));
		lblNewLabel.setBounds(0, -12, 619, 386);
		frame.getContentPane().add(lblNewLabel);
	}
}
