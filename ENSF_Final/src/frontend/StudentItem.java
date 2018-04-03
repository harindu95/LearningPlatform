package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import shared.Student;

public class StudentItem extends JPanel {

	
	private JLabel firstName;
	private JLabel lastName;
	private Student student;

	StudentItem(Student s, boolean enrolled) {
		JPanel panel = new JPanel();

		this.student = s;
		this.firstName = new JLabel(s.getFirstName());
		this.lastName = new JLabel(s.getLastName());
		Font font = new Font("Sans", Font.TRUETYPE_FONT, 18);
		JCheckBox enrolledCheckBox = new JCheckBox("Enrolled");
		enrolledCheckBox.setSelected(enrolled);
		panel.add(enrolledCheckBox);
		panel.add(firstName);
		panel.add(lastName);
		GridLayout l = new GridLayout(0, 1);
		l.setVgap(10);
		l.setHgap(10);
		panel.setLayout(l);
		this.setBackground(Color.WHITE);
		Color active = new Color(237, 82, 98);

		panel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, active));
		firstName.setFont(font);
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension(750, 100));

		this.add(panel);

	}
}
