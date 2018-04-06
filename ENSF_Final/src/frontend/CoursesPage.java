package frontend;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;



import shared.Course;
import shared.Professor;

public class CoursesPage extends Tab {

	private JPanel courses;
	private List<Course> courseList;
	private JDialog addClass;
	private JScrollPane scrollPane;
	private CardLayout cardsLayout;
	private JPanel tabs;
	private CoursePage coursePage;
	private Client client;

	CoursesPage(Client c,JPanel tabs, CardLayout cardsLayout) {
		addClass = new AddClassDialog(this);
		this.client = c;
		this.tabs = tabs;
		this.cardsLayout = cardsLayout;
		this.coursePage = new CoursePage(this,c,tabs,cardsLayout);
		tabs.add(coursePage, "course");
		Color redColor = new Color(123, 58, 220);
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setBackground(new Color(255, 255, 255));
		JLabel topLabel = new JLabel("Courses");
		topLabel.setIcon(new ImageIcon(getClass().getResource("/images/course_banner.png")));
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		topLabel.setPreferredSize(new Dimension(800, 100));
		this.add(topLabel, BorderLayout.NORTH);
		courses = new JPanel();
		courses.setBackground(Color.WHITE);
		GridLayout l = new GridLayout(0, 3);
		l.preferredLayoutSize(courses);
		l.setVgap(20);
		l.setHgap(30);
		courses.setLayout(l);
		scrollPane = new JScrollPane(courses);
		courses.setBorder(new javax.swing.border.EmptyBorder(30, 30, 30, 30));
		JPanel btns = new JPanel();
		JButton newClass = new JButton("New Course");
		btns.add(newClass);
		((FlowLayout) btns.getLayout()).setAlignment(FlowLayout.LEFT);
		btns.setBackground(Color.WHITE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(btns);
		container.add(scrollPane);
		this.add(container, BorderLayout.CENTER);
		scrollPane.setBorder(null);
		CoursesPage page = this;
		newClass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((AddClassDialog) addClass).showDialog();
			}

		});
	}

	void setCourses(List<Course> list) {
		this.courseList = list;

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				update();
			}
		});

	}

	void update() {
		courses.removeAll();
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			JPanel course = new CourseItem(c,coursePage);
			course.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					coursePage.setCourse(c);
					cardsLayout.show(tabs, "course");
				}
			});
			courses.add(course);

		}

		this.repaint();
		// scrollPane.revalidate();
		this.revalidate();
	}

	public void addCourse(Course c) {
		
		c.setProfessor((Professor)client.user);
		try {
			c = client.addCourse(c);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		courseList.add(c);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				update();
			}
		});
	}

	public void removeCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			client.removeCourse(course);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		courseList.remove(course);
		update();
	}

	public void readCourses() {
		// TODO Auto-generated method stub
		try {
			courseList = client.getCourses();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		update();
	}

}
