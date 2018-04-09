package frontend;

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

import com.sun.media.sound.ModelSource;

import shared.Assignment;
import shared.Course;
import shared.Student;

public class CoursePage extends JPanel {

	private Course course = new Course("Test");
	private JTextField topLabel;
	private JPanel assignments = null;
	private AssignmentDialog changeAssignment;
	private CardLayout cardLayout;
	private JPanel tabs;
	private StudentsPage students;
	private Client client;
	private JToggleButton toggle;
	private State state;
	private SubmissionPage submissionPage;

	public CoursePage(CoursesPage parent, Client c, State s,JPanel tabs, CardLayout cards) {
		this.tabs = tabs;
		this.cardLayout = cards;
		this.client = c;
		this.state = s;
		this.submissionPage = new SubmissionPage();
		students = new StudentsPage(c,s);
		tabs.add(students, "students");
		tabs.add(submissionPage, "dropbox");
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setBackground(new Color(255, 255, 255));
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
		JButton deleteCourse = new JButton("Delete Course");
		JButton addStudent = new JButton("Enroll/Unenroll");
		JButton addAssignmnet = new JButton("Add Assignment");
		toggle = new JToggleButton("Disabled");
		if (course.isActive()) {
			toggle.setText("Enabled");
			toggle.setSelected(true);
		}
		toggle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				course.setActive(toggle.isSelected());
				if(toggle.isSelected()) {
					toggle.setText("Enabled");
				}else {
					toggle.setText("Disabled");
				}
				parent.addCourse(course);
			}
		});
		
		((FlowLayout) btns.getLayout()).setAlignment(FlowLayout.LEFT);
		btns.add(addStudent);
		btns.add(addAssignmnet);
		btns.add(deleteCourse);
		btns.add(toggle);

		assignments = new JPanel();
		// FlowLayout l = new FlowLayout(ignments, BoxLayout.Y_AXIS);
		GridBagLayout l = new GridBagLayout();
		assignments.setLayout(l);
		assignments.setBackground(Color.white);
		container.add(new JScrollPane(assignments));
		add(container, BorderLayout.CENTER);

		changeAssignment = new AssignmentDialog(this);
		addAssignmnet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeAssignment.showDialog("Add Assignment", null);

			}
		});

		addStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				students.setCourse(course);
				cards.show(tabs, "students");
			}
		});

		deleteCourse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.removeCourse(course);
			}
		});
	}

	void update() {
		assignments.removeAll();
		GridBagConstraints c = new GridBagConstraints();

		for (int i = 0; i < course.assignments.size(); i++) {
			c.gridy = i;

			Assignment a = course.assignments.get(i);
			AssignmentItem assignment = new AssignmentItem(a);
			assignment.AddEditBtnActionLiistener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					changeAssignment.showDialog("Change Assignment", a);
				}
			});
			
			assignment.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					submissionPage.setAssignment(a);
					cardLayout.show(tabs, "dropbox");
					
				}
			});
			assignment.AddClsBtnActionLiistener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					course.assignments.remove(a);
					try {
						client.removeAssignment(a);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					update();
				}
			});
		
			assignments.add(assignment, c);

		}

		System.out.println(course.assignments.size());
		this.repaint();
		this.revalidate();
	}

	public void setCourse(Course c) {
		// TODO Auto-generated method stub
		topLabel.setText(c.getName());
		toggle.setSelected(c.isActive());
		if(toggle.isSelected()) {
			toggle.setText("Enabled");
		}else {
			toggle.setText("Disabled");
		}
		this.course = c;
		update();
	}

	public void addAssignment(Assignment assign) {
		if (assign != null) {
			assign.setCourse(course);
			try {
				course.assignments = client.updateAssignment(assign);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					update();
				}
			});
		}
	}

}
