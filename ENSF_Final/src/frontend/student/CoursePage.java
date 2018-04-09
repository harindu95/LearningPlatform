package frontend.student;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import frontend.Client;
import shared.Assignment;
import shared.Course;
import shared.Student;

public class CoursePage extends JPanel {

	private Course course = new Course("Test");
	private JTextField topLabel;
	private JPanel assignments = null;
	private CardLayout cardLayout;
	private JPanel tabs;
	private Client client;

	public CoursePage(CoursesPage parent, Client c, JPanel tabs, CardLayout cards) {
		this.tabs = tabs;
		this.cardLayout = cards;
		this.client = c;
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setBackground(Color.white);
		topLabel = new JTextField(course.getName());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(topLabel, BorderLayout.CENTER);
		topPanel.setBackground(Color.WHITE);
		Font font = new Font("Sans", Font.PLAIN, 48);
		topLabel.setAlignmentX(8);
		topLabel.setFont(font);
		topLabel.setEditable(false);
		// topLabel.setIcon(new
		// ImageIcon(getClass().getResource("/images/course_banner.png")));
		topLabel.setBackground(new Color(25, 114, 120));
		topPanel.setBorder(new EmptyBorder(15, -1, 15, -1));
		topLabel.setForeground(Color.WHITE);
		topLabel.setHorizontalAlignment(JLabel.LEFT);
		topLabel.setPreferredSize(new Dimension(800, 70));
		this.add(topPanel, BorderLayout.NORTH);

		JPanel container = new JPanel();
		JPanel btns = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(btns);
		btns.setBackground(Color.WHITE);
		container.setBackground(Color.white);
		((FlowLayout) btns.getLayout()).setAlignment(FlowLayout.LEFT);

		assignments = new JPanel();
		// FlowLayout l = new FlowLayout(ignments, BoxLayout.Y_AXIS);
		GridBagLayout l = new GridBagLayout();
		assignments.setLayout(l);
		assignments.setBackground(Color.white);
		container.add(new JScrollPane(assignments));
		add(container, BorderLayout.CENTER);

	}

	void update() {
		assignments.removeAll();
		GridBagConstraints c = new GridBagConstraints();

		for (int i = 0; i < course.assignments.size(); i++) {
			c.gridy = i;

			Assignment a = course.assignments.get(i);
			AssignmentItem assignment = new AssignmentItem(a);

			// course.addMouseListener(new MouseAdapter() {

			// @Override
			// public void mouseClicked(MouseEvent e) {
			// super.mouseClicked(e);
			// coursePage.setCourse(c);
			// cardsLayout.show(tabs, "course");
			// }
			// });
			assignments.add(assignment, c);

		}

		System.out.println(course.assignments.size());
		this.repaint();
		this.revalidate();
	}

	public void setCourse(Course c) {
		// TODO Auto-generated method stub
		topLabel.setText(c.getName());
		this.course = c;
		update();
	}

}
