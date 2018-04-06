package frontend;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;

import shared.Assignment;
import shared.Course;
import shared.Student;

public class StudentsPage extends JPanel {

	private Course course = new Course("Test");
	private JTextField topLabel;
	private JPanel students = null;
	// private JDialog changeAssignment;
	private List<Student> studentList;
	private Client client;

	public StudentsPage(Client c) {

		this.client = c;
		try {
			this.studentList = c.getAllStudents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setBackground(new Color(255, 255, 255));
		topLabel = new JTextField("Students");
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(topLabel, BorderLayout.CENTER);
		topPanel.setBackground(Color.WHITE);
		Font font = new Font("Sans", Font.PLAIN, 48);
		topLabel.setAlignmentX(8);
		topLabel.setFont(font);
		topLabel.setEditable(false);
		topLabel.setBackground(new Color(25, 114, 120));
		topPanel.setBorder(new EmptyBorder(15, -1, 15, -1));
		topLabel.setForeground(Color.WHITE);
		topLabel.setHorizontalAlignment(JLabel.LEFT);
		topLabel.setPreferredSize(new Dimension(800, 70));
		this.add(topPanel, BorderLayout.NORTH);

		JPanel container = new JPanel();
		JPanel btns = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		container.setLayout(layout);
		constraints.anchor = GridBagConstraints.PAGE_START;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.ipady = 20;
		constraints.fill = GridBagConstraints.BOTH;
		container.add(btns, constraints);
		btns.setBackground(Color.WHITE);
		container.setBackground(Color.white);
		JTextField searchbox = new JTextField(20);
		JButton search = new JButton("Search");
		JButton enroll = new JButton("Enroll");
		JButton unenroll = new JButton("Unenroll");
		JButton email = new JButton("Email");
		((FlowLayout) btns.getLayout()).setAlignment(FlowLayout.LEFT);
		btns.add(searchbox);
		btns.add(search);
		btns.add(enroll);
		btns.add(unenroll);
		btns.add(email);
		students = new JPanel();
		BoxLayout l = new BoxLayout(students, BoxLayout.Y_AXIS);
		students.setLayout(l);
		constraints.gridy = 1;

		container.add(new JScrollPane(students), constraints);
		add(container, BorderLayout.CENTER);

		update();

	}

	void update() {
		students.removeAll();
		System.out.println("Updating... students page");
		for (int i = 0; i < studentList.size(); i++) {
			Student s = studentList.get(i);
			boolean enrolled = false;
			if (s.getCourses().contains(course)) {
				enrolled = true;
			}else {
				System.out.println();
			}
			StudentItem student = new StudentItem(this, s, enrolled);
			students.add(student);

		}

		// System.out.println(course.assignments.size());
		this.repaint();
		this.revalidate();
	}

	public void setCourse(Course c) {
		// TODO Auto-generated method stub
		this.course = c;
		update();
	}

	public void updateEnrollment(Student s, boolean selected) {
		// TODO Auto-generated method stub

		try {
			course = client.updateEnrollment(course, s,selected);
			studentList = client.getAllStudents();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		update();
	}

}
