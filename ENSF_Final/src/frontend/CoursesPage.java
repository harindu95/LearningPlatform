package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import shared.Course;

public class CoursesPage extends Tab{

	private JPanel courses;

	CoursesPage(){
		this.setLayout(new BorderLayout());
		JLabel topLabel = new JLabel("Courses");
		this.add(topLabel, BorderLayout.NORTH);
		courses = new JPanel();
		this.add(courses,BorderLayout.CENTER);
		GridLayout l = new GridLayout();
		l.setVgap(20);
		courses.setLayout(l);
	}
	
	void setCourses(List<Course> list) {
		for(int i =0; i<list.size();i++) {
			Course c =list.get(i);
			JLabel course = new JLabel(c.getName());
			course.setMaximumSize(new Dimension(700, 30));
			courses.add(course);
		}
	}
}
