package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import shared.Assignment;
import shared.Submission;

public class SubmissionItem extends JPanel {

	private JLabel name;
	private Assignment assign = null;
	private JLabel due_date;
	private JButton submit;
	private JButton download;
	private Submission submission;
	private JLabel stdID;
	private JLabel stdFrist;
	private JLabel stdLast;
	 JTextField grade2;

	public SubmissionItem(Submission s) {
		JPanel panel = new JPanel();

		this.submission = s;
		this.name = new JLabel(s.getTitle());
		// this.due_date = new JLabel("Due date: " + a.getDue_date());

		Font font = new Font("Sans", Font.TRUETYPE_FONT, 18);

		panel.add(name);
		// panel.add(due_date);
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 0;
		c.gridx = 0;
		c.ipadx = 20;
		panel.setLayout(l);
		this.setBackground(Color.WHITE);

		Color active = new Color(237, 82, 98);
		// Color deactive = Color.GRAY;
		Color border = active;

		this.download = new JButton("Download");
		name.setFont(font);
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension(750, 100));

		Font font2 = new Font(Font.SERIF, Font.TRUETYPE_FONT, 15);
		JLabel grade = new JLabel("Grade:");
		grade2 = new JTextField(2);
		grade2.setText(s.getSubmission_grade() +"");
		JPanel container = new JPanel();

		stdID = new JLabel("Student ID: " + s.getStudent().id);
		stdID.setFont(font2);
		stdFrist = new JLabel(s.getStudent().getFirstName() + " " + s.getStudent().getLastName());
		stdFrist.setFont(font2);
		stdLast = new JLabel(s.getPath());
		stdLast.setFont(font2);

		panel.add(stdID, c);
		c.gridx = 1;
		panel.add(stdFrist,c);
		c.gridx = 2;
		panel.add(stdLast, c);

		this.add(new JScrollPane(container));
		container.add(panel);
		container.add(grade);
		container.add(grade2);
		container.add(download);
		container.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, border));
		
	}

	void addDOcumentListner(DocumentListener l) {
		grade2.getDocument().addDocumentListener(l);
	}
	void keyPressListener(KeyListener l) {
		grade2.addKeyListener(l);
	}
	
	void actionListener(ActionListener l) {
		download.addActionListener(l);
	}
}
