package frontend;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame;
	private JTextField txtDashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setSize(972,506);
		//frame.setResizable(false);
		frame.setBounds(100, 100, 1280+16, 728+38);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 728);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtDashboard = new JTextField();
		txtDashboard.setEditable(false);
		txtDashboard.setText("Dashboard");
		txtDashboard.setBounds(46, 383, 86, 20);
		panel.add(txtDashboard);
		txtDashboard.setColumns(10);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1280, 733);
		background.setIcon(new ImageIcon("resources/images/windowBase.png"));
		panel.add(background);
	}
	
	public void displayMessage (String Message)
	{
		JOptionPane.showMessageDialog(null, Message, "Message", JOptionPane.OK_OPTION);
	}
	
	public String getUserInput(String Message)
	{
		return JOptionPane.showInputDialog(null, Message, "Input", JOptionPane.OK_CANCEL_OPTION);
	}
}
