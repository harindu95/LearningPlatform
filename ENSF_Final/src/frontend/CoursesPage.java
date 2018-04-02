package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import shared.Course;

public class CoursesPage extends Tab {

	private JPanel courses;
	Color[] palette = {
			rgb(241,196,15),
			rgb(46,204,113),
			rgb(231,76,60),
			new Color(255, 107, 107),
			new Color(72, 219, 251),
			new Color(254, 202, 87),
			new Color(243, 104, 224),
			new Color(0, 210, 211),
			new Color(84, 160, 255),
			new Color(95, 39, 205),
			new Color(200, 214, 229),
			new Color(87, 101, 116),
			new Color(34, 47, 62),
			new Color(52, 31, 151),
			new Color(1, 163, 164),
			new Color(72, 219, 251)
	};
	private int paletteIndex = 0;

	CoursesPage() {
		Color redColor = new Color(123, 58, 220);
		BorderLayout borderLayout = new BorderLayout();
//		borderLayout.setHgap(40);
//		borderLayout.setVgap(50);
		this.setLayout(borderLayout);
		this.setBackground(new Color(255, 255, 255));
		JLabel topLabel = new JLabel("Courses");
		topLabel.setIcon(new ImageIcon(getClass().getResource("/images/CoursesBanner2.png")));
//		topLabel.setBackground(redColor);
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
		JScrollPane scrollPane = new JScrollPane(courses);
		courses.setBorder(new javax.swing.border.EmptyBorder(30, 30, 30, 30));
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBorder(null);
	}

	void setCourses(List<Course> list) {
		int k = 1;
		Font font = new Font("Sans", Font.TRUETYPE_FONT, 18);
		while (k < 4) {
			for (int i = 0; i < list.size(); i++) {
				Course c = list.get(i);

				JTextField course = new JTextField(c.getName());
				course.setHorizontalAlignment(JTextField.CENTER);
				course.setFont(font);
				course.setEditable(false);
				course.setPreferredSize(new Dimension(150, 150));
				course.setBorder(new BevelBorder(BevelBorder.RAISED));
				course.setBackground(randomColor());
				course.setForeground(Color.WHITE);
				courses.add(course);

			}
			k++;
		}
	}

	Color randomColor() {
//		int index = (int)(Math.random() * palette.length);
		paletteIndex = (paletteIndex + 1) % palette.length;
		return palette[paletteIndex];
		
	}
	static Color rgb(int r, int g, int b) {
		return new Color(r, g, b);
	}
}
