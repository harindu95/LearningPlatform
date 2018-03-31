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
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		Color redColor = new Color(237,82,98);
		frame = new JFrame();
		//frame.setSize(972,506);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280+16, 728+38);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 728);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel dashboardIcon = new JLabel();
		dashboardIcon.setIcon(new ImageIcon(getClass().getResource("\\dashboard_hover.png")));
		dashboardIcon.setBounds(10, 377, 50, 50);
		panel.add(dashboardIcon);
		
		JLabel gradeIcon = new JLabel();
		gradeIcon.setIcon(new ImageIcon(getClass().getResource("\\grade.png")));
		gradeIcon.setBounds(10, 463, 50, 50);
		panel.add(gradeIcon);
		
		JLabel otherIcon = new JLabel();
		otherIcon.setIcon(new ImageIcon(getClass().getResource("\\other.png")));
		otherIcon.setBounds(10, 556, 50, 50);
		panel.add(otherIcon);
		
		JLabel greenButton = new JLabel();
		greenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				greenButton.setIcon(new ImageIcon(getClass().getResource("\\green_hover.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				greenButton.setIcon(new ImageIcon(getClass().getResource("")));
			}
		});
		greenButton.setBounds(594, 335, 292, 271);
		panel.add(greenButton);
		
		JLabel lblGrades = new JLabel("Grades");
		lblGrades.setForeground(Color.WHITE);
		lblGrades.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblGrades.setBounds(70, 456, 128, 74);
		lblGrades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblGrades.setForeground(redColor);
				gradeIcon.setIcon(new ImageIcon(getClass().getResource("\\grade_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblGrades.setForeground(Color.WHITE);
				gradeIcon.setIcon(new ImageIcon(getClass().getResource("\\grade.png")));
			}
		});
		panel.add(lblGrades);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(redColor);
		lblDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblDashboard.setForeground(redColor);
				dashboardIcon.setIcon(new ImageIcon(getClass().getResource("\\dashboard_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblDashboard.setForeground(Color.WHITE);
				dashboardIcon.setIcon(new ImageIcon(getClass().getResource("\\dashboard.png")));

				
			}
		});
		lblDashboard.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblDashboard.setBounds(70, 368, 128, 74);
		panel.add(lblDashboard);
		
		JLabel other = new JLabel("Other");
		other.setForeground(Color.WHITE);
		other.setFont(new Font("Calibri", Font.PLAIN, 22));
		other.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				other.setForeground(redColor);
				otherIcon.setIcon(new ImageIcon(getClass().getResource("\\other_hover.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				other.setForeground(Color.WHITE);
				otherIcon.setIcon(new ImageIcon(getClass().getResource("\\other.png")));
			}
		});
		other.setBounds(70, 545, 128, 74);
		panel.add(other);
		
		JLabel purpleButton = new JLabel();
		purpleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				purpleButton.setIcon(new ImageIcon(getClass().getResource("\\purple_hover.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				purpleButton.setIcon(new ImageIcon(getClass().getResource("")));
			}
		});
		purpleButton.setBounds(267, 335, 292, 271);
		
		panel.add(purpleButton);
		
		JLabel blueButton = new JLabel();
		blueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				blueButton.setIcon(new ImageIcon(getClass().getResource("\\blue_hover.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				blueButton.setIcon(new ImageIcon(getClass().getResource("")));
			}
		});
		blueButton.setBounds(922, 335, 292, 271);
		panel.add(blueButton);
		
		
		
		JLabel main = new JLabel("");
		main.setBounds(0, 0, 1280, 733);
		main.setIcon(new ImageIcon(getClass().getResource("\\main.png")));
		panel.add(main);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 560, 46, 14);
		panel.add(lblNewLabel);
		
		
		
	
	}
}
