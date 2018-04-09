package frontend.student;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frontend.Client;
import frontend.GUI;
import shared.Professor;
import shared.Request;
import shared.Student;

public class StudentGUI extends GUI
{

	public JFrame frame;
	private JTextField txtDashboard;
	private JPanel tabs;
	private CardLayout cardsLayout;
	private Client client;
	private Student user;



	/**
	 * Create the application.
	 * @param u 
	 */
	public StudentGUI(Client c, Student u) {
		this.client = c;
		this.user = u;
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
		CoursesPage courses = new CoursesPage(client,tabs, cardsLayout);

		JPanel welcomePage = new WelcomePage();
		tabs.add(welcomePage, "welcomePage");
		welcomePage.setLayout(new BorderLayout());
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(Student.class.getResource("/banner.jpg")));
		welcomePage.add(background,BorderLayout.CENTER);

		tabs.add(courses, "courses");

		JPanel Settings = new JPanel();
		Settings.setLayout(null);

		tabs.add(Settings, "settings");

		JLabel lblSettingsbackground = new JLabel("");
		lblSettingsbackground.setIcon(new ImageIcon(getClass().getResource("/images/settings.jpg")));
		lblSettingsbackground.setBounds(0, 0, 1019, 628);
		Settings.add(lblSettingsbackground);

		JLabel dashboardIcon = new JLabel();
		dashboardIcon.setIcon(new ImageIcon(getClass().getResource("/images/dashboard_hover.png")));
		dashboardIcon.setBounds(16, 380, 50, 50);
		panel.add(dashboardIcon);

		JLabel courseIcon = new JLabel();
		courseIcon.setIcon(new ImageIcon(getClass().getResource("/images/courses.png")));
		courseIcon.setBounds(16, 440, 50, 50);
		panel.add(courseIcon);

		JLabel settingsIcon = new JLabel();
		settingsIcon.setIcon(new ImageIcon(getClass().getResource("/images/settings.png")));
		settingsIcon.setBounds(16, 502, 40, 50);
		panel.add(settingsIcon);

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
				cardsLayout.show(tabs, "welcomePage");
			}
		});
		lblDashboard.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblDashboard.setBounds(65, 388, 133, 43);
		panel.add(lblDashboard);

		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblSettings.setForeground(redColor);
				settingsIcon.setIcon(new ImageIcon(getClass().getResource("/images/settings_hover.png")));
				// otherIcon.setIcon(new
				// ImageIcon(getClass().getResource("/images/other_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblSettings.setForeground(Color.WHITE);
				settingsIcon.setIcon(new ImageIcon(getClass().getResource("/images/settings.png")));
				// otherIcon.setIcon(new
				// ImageIcon(getClass().getResource("/images/other.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cardsLayout.show(tabs, "settings");
			}
		});
		lblSettings.setBounds(72, 518, 128, 74);
		panel.add(lblSettings);

		lblSettings.setBounds(65, 510, 128, 38);
		panel.add(lblSettings);

		JLabel closeBtn = new JLabel("New label");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(getClass().getResource("/images/closebtn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(getClass().getResource("/images/closebtn2.png")));
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(getClass().getResource("/images/closebtn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				closeBtn.setIcon(new ImageIcon(getClass().getResource("/images/closebtn1.png")));
			}
		});

		closeBtn.setIcon(new ImageIcon(getClass().getResource("/images/closebtn1.png")));
		closeBtn.setBounds(1257, 0, 20, 20);
		panel.add(closeBtn);

		JLabel minBtn = new JLabel("New label");
		minBtn.setIcon(new ImageIcon(getClass().getResource("/images/minbtn1.png")));
		minBtn.setBounds(1238, 0, 20, 20);
		minBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(getClass().getResource("/images/minbtn3.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(getClass().getResource("/images/minbtn2.png")));
				frame.setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(getClass().getResource("/images/minbtn2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minBtn.setIcon(new ImageIcon(getClass().getResource("/images/minbtn1.png")));
			}
		});

		panel.add(minBtn);

		JLabel lblLogOut = new JLabel("");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogOut.setIcon(new ImageIcon(getClass().getResource("/images/logout_hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblLogOut.setIcon(new ImageIcon(getClass().getResource("/images/logout.png")));
			}

		});
		lblLogOut.setBounds(27, 676, 152, 38);
		lblLogOut.setIcon(new ImageIcon(getClass().getResource("/images/logout.png")));
		panel.add(lblLogOut);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setForeground(Color.WHITE);
		lblCourses.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblCourses.setBounds(65, 440, 128, 38);
		panel.add(lblCourses);
		lblCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				courses.readCourses();
				cardsLayout.show(tabs, "courses");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCourses.setForeground(redColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCourses.setForeground(Color.WHITE);
			}
			
		});

		JLabel main = new JLabel("");
		main.setBounds(0, 0, 1280, 728);
		main.setIcon(new ImageIcon(getClass().getResource("/images/main.png")));
		panel.add(main);
		cardsLayout.show(tabs, "welcomePage");
	}

	public Request choices() {
		// TODO Auto-generated method stub
		return null;
	}

}
