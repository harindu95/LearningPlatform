package frontend;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import shared.Course;
import shared.Request;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class GUI {

	private JFrame frame;
	private JTextField txtDashboard;
	private JPanel tabs;
	private CardLayout cardsLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
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
		Color redColor = new Color(237, 82, 98);
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1280 + 16, 728 + 38);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 728);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 728);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		tabs = new JPanel();
		tabs.setBounds(228, 70, 1019, 628);
		panel.add(tabs);
		cardsLayout = new CardLayout(0, 0);
		tabs.setLayout(cardsLayout);
		JLabel dashboardIcon = new JLabel();
		dashboardIcon.setIcon(new ImageIcon(GUI.class.getResource("/images/dashboard.png")));
		dashboardIcon.setBounds(10, 377, 50, 50);
		panel.add(dashboardIcon);

		JLabel gradeIcon = new JLabel();
		gradeIcon.setIcon(new ImageIcon(GUI.class.getResource("/images/grade.png")));
		gradeIcon.setBounds(10, 463, 50, 50);
		panel.add(gradeIcon);

		JLabel otherIcon = new JLabel();
		otherIcon.setIcon(new ImageIcon(getClass().getResource("/images/other.png")));
		otherIcon.setBounds(10, 556, 50, 50);
		panel.add(otherIcon);

		JLabel greenButton = new JLabel();
		greenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				greenButton.setIcon(new ImageIcon(getClass().getResource("/images/green_hover.jpg")));
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
				gradeIcon.setIcon(new ImageIcon(getClass().getResource("/images/grade_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblGrades.setForeground(Color.WHITE);
				gradeIcon.setIcon(new ImageIcon(getClass().getResource("/images/grade.png")));
			}
		});
		panel.add(lblGrades);

		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(redColor);
		lblDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblDashboard.setForeground(redColor);
				dashboardIcon.setIcon(new ImageIcon(getClass().getResource("/images/dashboard_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblDashboard.setForeground(Color.WHITE);
				dashboardIcon.setIcon(new ImageIcon(getClass().getResource("/images/dashboard.png")));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardsLayout.show(tabs, "Dashboard");
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
				otherIcon.setIcon(new ImageIcon(getClass().getResource("/images/other_hover.png")));

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				other.setForeground(Color.WHITE);
				otherIcon.setIcon(new ImageIcon(getClass().getResource("/images/other.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardsLayout.show(tabs, "Courses");
			}
		});
		other.setBounds(70, 545, 128, 74);
		panel.add(other);

		JLabel purpleButton = new JLabel();
		purpleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				purpleButton.setIcon(new ImageIcon(getClass().getResource("/images/purple_hover.jpg")));
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
				blueButton.setIcon(new ImageIcon(getClass().getResource("/images/blue_hover.jpg")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				blueButton.setIcon(new ImageIcon(getClass().getResource("")));
			}
		});
		blueButton.setBounds(922, 335, 292, 271);
		panel.add(blueButton);

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
		closeBtn.setBounds(1257, 0, 20, 20);
		panel.add(closeBtn);

		JLabel minBtn = new JLabel("New label");
		minBtn.setIcon(new ImageIcon(GUI.class.getResource("/images/minbtn1.png")));
		minBtn.setBounds(1238, 0, 20, 20);
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

		JLabel main = new JLabel("");
		main.setBounds(0, 0, 1280, 728);
		main.setIcon(new ImageIcon(GUI.class.getResource("/images/main.png")));
		panel.add(main);
		setupTabs();
	}

	public void setupTabs() {
		
		tabs.add(new WelcomePage(), "Dashboard");
		CoursesPage courses = new CoursesPage(tabs,cardsLayout);
		List<Course> list = new ArrayList<>();
		list.add(new Course(2, "MATH271"));
		list.add(new Course(3, "ENCM369"));
		list.add(new Course(5, "ENSF409"));
		list.add(new Course(6, "MATH211"));
		courses.setCourses(list);
		tabs.add(courses, "Courses");
		
	}
	public Request choices() {
		// TODO Auto-generated method stub
		return null;
	}
}
