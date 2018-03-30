package frontend;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class GUI {

	private JFrame frame;
	private JTextField txtDashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
		frame.setUndecorated(true);
		
		frame.setSize(1280,728);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 728);
		frame.setLocationRelativeTo(null);
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
		
		JLabel closeBtn = new JLabel("New label");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn2.png")));
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn2.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn1.png")));
			}
		});
		closeBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/closebtn1.png")));
		closeBtn.setBounds(1257, 6, 20,20);
		panel.add(closeBtn);
		
		JLabel minBtn = new JLabel("New label");
		minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn1.png")));
		minBtn.setBounds(1228, 6, 20, 20);
		minBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn2.png")));
				frame.setState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn2.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn1.png")));
			}
		});
		panel.add(minBtn);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1280, 728);
		background.setIcon(new ImageIcon(GUI.class.getResource("/images/main3.png")));
		panel.add(background);
		
	
	}
}
