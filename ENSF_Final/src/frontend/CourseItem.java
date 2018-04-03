package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import shared.Course;

import javax.swing.ImageIcon;
import java.awt.Color;

public class CourseItem extends JPanel {

	Course course;
	
	CourseItem(Course c){
		super();
		
		this.course = c;
		this.setSize(279,361);
		this.setPreferredSize(new Dimension(279,361));
		this.setMaximumSize(new Dimension(279,361));
		setLayout(null);
		
		Font font = new Font("Sans",Font.TRUETYPE_FONT, 24);
		JLabel title = new JLabel(c.getName());
		title.setFont(font);
		title.setBounds(10, 209, 279, 47);
		title.setIcon(null);
		add(title);
		
		JLabel lblDescription = new JLabel(c.description);
		lblDescription.setBounds(10, 249, 259, 23);
		lblDescription.setFont(font);
		add(lblDescription);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(CourseItem.class.getResource("/images/test_course_image.png")));
		image.setBounds(0, 0, 279, 144);
		add(image);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(CourseItem.class.getResource("/images/course.png")));
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 279, 361);
		add(background);
	}
}
