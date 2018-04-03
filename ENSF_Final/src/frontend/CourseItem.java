package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import shared.Course;

public class CourseItem extends JPanel {

	private JLabel name;
	private CoursePage coursePage;

	CourseItem(Course c, CoursePage page){
		this.name = new JLabel(c.getName());
		this.coursePage = page;
		name.setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Sans", Font.TRUETYPE_FONT, 18);
		this.setLayout(new BorderLayout());
		this.add(name,BorderLayout.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, new Color(237, 82, 98)));
		name.setFont(font);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(150, 150));
	}
}
