package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import shared.Course;
import shared.Student;

public class StudentsPage extends JPanel {

	private Course course = new Course("Test");
	private JTextField topLabel;
	private JPanel students = null;
	// private JDialog changeAssignment;
	private List<Student> studentList;
	private List<Student> searchList;
	private Client client;
	private JRadioButton radio_lastName;
	private JRadioButton radio_id;
	private State state;

	public StudentsPage(Client c, State s) {

		this.client = c;
		this.state = s;
		try {
			this.studentList = c.getAllStudents();
			this.searchList = studentList;
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

		this.radio_id = new JRadioButton("ID");
		this.radio_lastName = new JRadioButton("Last name");
		radio_lastName.setSelected(true);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radio_id);
		btnGroup.add(radio_lastName);
		radio_id.setBackground(Color.white);
		radio_lastName.setBackground(Color.white);
		JPanel search_type = new JPanel();
		search_type.setBackground(Color.white);
		search_type.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.anchor = GridBagConstraints.WEST;
		c1.insets = new Insets(20, 20, 20, 20);
		c1.gridx = 0;
		c1.gridy = 0;
		search_type.add(radio_id, c1);
		c1.gridy = 1;
		search_type.add(radio_lastName, c1);

		this.add(search_type, BorderLayout.WEST);
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
		StudentsPage page = this;
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (searchbox.getText().trim().isEmpty()) {
					searchList = studentList;

				} else {
					if (radio_id.isSelected()) {
						try {
							int id = Integer.parseInt(searchbox.getText());
							searchList = new ArrayList<>();
							for (int i = 0; i < studentList.size(); i++) {
								if (studentList.get(i).id == id) {
									searchList.add(studentList.get(i));
								}

							}
						} catch (NumberFormatException er) {
							JOptionPane.showConfirmDialog(null, "Invalid id");
						}
					} else if (radio_lastName.isSelected()) {
						searchList = new ArrayList<>();
						String regex = "(?i).*"+ searchbox.getText().toLowerCase() + ".*";
						for (int i = 0; i < studentList.size(); i++) {
							if (studentList.get(i).getLastName().matches(regex)) {
								searchList.add(studentList.get(i));
							}

						}
					}
				}
				page.update();
			}
		});

	}

	void update() {
		students.removeAll();
		System.out.println("Updating... students page");
		for (int i = 0; i < searchList.size(); i++) {
			Student s = searchList.get(i);
			boolean enrolled = false;
			if (s.getCourses().contains(course)) {
				enrolled = true;
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
		this.searchList = studentList;
		update();
	}

	public void updateEnrollment(Student s, boolean selected) {
		// TODO Auto-generated method stub

		try {
			System.out.println("update enrollment");
			client.updateEnrollment(course, s, selected);
			studentList = state.students;
			setCourse(state.getCourse(course.getId()));
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
