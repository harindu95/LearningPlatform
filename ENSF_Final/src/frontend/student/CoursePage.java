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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import frontend.Client;
import frontend.EmailSender;
import shared.Assignment;
import shared.Course;
import shared.FileObj;
import shared.Student;
import shared.Submission;

public class CoursePage extends JPanel {

	private Course course = new Course("Test");
	private JTextField topLabel;
	private JPanel assignments = null;
	private CardLayout cardLayout;
	private JPanel tabs;
	private Client client;
	private JButton email;
	private EmailSender emailSenderFrame;
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
		
		email = new JButton("Email");
		emailSenderFrame = new EmailSender(c);
		
		btns.add(email);
		btns.setBackground(Color.WHITE);
		
		email.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				emailSenderFrame.addReciever(course.getProfessor().getEmail());
				emailSenderFrame.showWindow(client.state.user.getEmail(), course.getProfessor().getEmail());
			}
		});
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
			
			if(a.isActive())
			{
				AssignmentItem assignment = new AssignmentItem(a, (Student)client.state.user);
				assignment.addSubmitActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						submitAction(a);
					}
				});
				
				assignment.addDownloadActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						downloadAction(a);
					}
				});
				
				assignments.add(assignment, c);
			}
			// course.addMouseListener(new MouseAdapter() {

			// @Override
			// public void mouseClicked(MouseEvent e) {
			// super.mouseClicked(e);
			// coursePage.setCourse(c);
			// cardsLayout.show(tabs, "course");
			// }
			// });
			//assignments.add(assignment, c);

		}

		System.out.println(course.assignments.size());
		this.repaint();
		this.revalidate();
	}

	public void downloadAction(Assignment a)
	{
		JFileChooser fileDownload = new JFileChooser();
		
		FileObj file = a.getFile();
		fileDownload.setSelectedFile(new File(file.file.getName()));
		int r = fileDownload.showSaveDialog(this);
		
		if(r == JFileChooser.APPROVE_OPTION)
		{
			try {
				storeFile(fileDownload.getSelectedFile().getAbsolutePath(),file.data);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void storeFile(String filename, byte[] data) throws IOException {
		Files.write(Paths.get(filename), data);
	}


	public void submitAction(Assignment a)  
	{
		JFileChooser chooser = new JFileChooser();
		int r = chooser.showOpenDialog(this);
		if(r == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			Submission s = new Submission();
			DateFormat fmt = new SimpleDateFormat("y-M-d h:m:s");
			String time = fmt.format(Calendar.getInstance().getTime());
			if(time.length() > 16) {
				time = time.substring(0,16);
			}
			s.setTimeStamp(time);
			s.setStudent((Student)client.state.user);
			s.setAssignment(a);
			
			try {
				s.setFile(new FileObj(file));
				client.uploadSubmission(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			s.setPath();
		}
	}
	
	public void setCourse(Course c) {
		// TODO Auto-generated method stub
		topLabel.setText(c.getName());
		this.course = c;
		this.emailSenderFrame.to.clear();
		update();
	}

}
