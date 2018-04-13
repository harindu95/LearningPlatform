package frontend.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import shared.Assignment;
import shared.Student;

public class AssignmentItem extends JPanel {

	private JLabel name;
	private Assignment assign = null;
	private JLabel due_date;
	private JButton submit;
	private JButton download;
	

	public AssignmentItem(Assignment a,Student s) {
		JPanel panel = new JPanel();

		this.assign = a;
		this.name = new JLabel(a.getTitle());
		this.due_date = new JLabel("Due date: " + a.getDue_date());

		Font font = new Font("Sans", Font.TRUETYPE_FONT, 18);

		panel.add(name);
		panel.add(due_date);
		GridLayout l = new GridLayout(0, 1);
		l.setVgap(10);
		l.setHgap(10);
		panel.setLayout(l);
		this.setBackground(Color.WHITE);
		
		Color active = new Color(237, 82, 98);
		Color deactive = Color.GRAY;
		Color border = active;
		
		this.download = new JButton("Download");
		this.submit = new JButton("Submit");
		name.setFont(font);
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension(750, 100));
		

		panel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, border));
		JLabel temp = new JLabel("Grade: " + s.getGrade(a.getId()));
		System.out.println(s.id + " ::::::::: "  + a.getId());
		this.add(panel);
		this.add(temp);
		this.add(download);
		this.add(submit);
	}
	
	void addSubmitActionListener(ActionListener l) {
		submit.addActionListener(l);
	}
	
	void addDownloadActionListener(ActionListener l) {
		download.addActionListener(l);
	}
}
