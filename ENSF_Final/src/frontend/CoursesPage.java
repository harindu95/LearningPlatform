package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import javafx.scene.layout.Border;
import shared.Course;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CoursesPage extends JPanel {
	private JPanel courses;
	private JDialog newCourse;
	public List<Course> courseList;
	private JScrollPane scrollPane;

	CoursesPage() {
		setLayout(null);
		this.setSize(1020, 607);
		// add(courses);
		newCourse = new AddClass(this);
		newCourse.setLocationRelativeTo(this);
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(0, 67, 1020, 846);
		add(layeredPane_1);

		courses = new JPanel();
		courses.setBackground(Color.WHITE);
		courses.setBounds(0, 67, 1020, 846);
		FlowLayout l = new WrapLayout(FlowLayout.CENTER, 40, 40);
		
//		l.setHgap(45);
//		l.setVgap(40);
		courses.setLayout(l);
		courses.setBorder(new EmptyBorder(30, 30, 30, 30));
		scrollPane = new JScrollPane(courses);
		layeredPane_1.setLayer(scrollPane, -1);
		scrollPane.setBounds(0, 0, 1020, 800);
		
		layeredPane_1.add(scrollPane);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(CoursesPage.class.getResource("/images/add_btn2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(CoursesPage.class.getResource("/images/add_btn.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				newCourse.setVisible(true);
			}
		});
		lblNewLabel.setBounds(932, 396, 78, 107);
		layeredPane_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(CoursesPage.class.getResource("/images/add_btn.png")));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CoursesPage.class.getResource("/images/courses_page.png")));
		label.setBounds(0, 0, 1020, 607);
		add(label);
	}

	void setCourses(List<Course> list) {
		
		this.courseList = list;
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				courses.removeAll();
				update();		
			}
		});
		
	}
	void update() {
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(i);
			CourseItem course = new CourseItem(c);
			courses.add(course);
		}
		
		this.repaint();
		this.revalidate();
//		
	}
}
