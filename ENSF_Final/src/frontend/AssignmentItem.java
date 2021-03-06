package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

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

public class AssignmentItem extends JPanel {

	private JLabel name;
	private Assignment assign = null;
	private JLabel due_date;
	private JButton close;
	private JButton edit;

	public AssignmentItem(Assignment a) {
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
		Color border = deactive;
		
		name.setFont(font);
		panel.setBackground(Color.white);
		panel.setPreferredSize(new Dimension(750, 100));
		close = new JButton("X");
		edit = new JButton("edit");
		JToggleButton activated = new JToggleButton("Deactive");
		activated.setFont(new Font(Font.MONOSPACED,Font.TRUETYPE_FONT,12));
		if (a.isActive()) {
			border = active;
			activated.setSelected(true);
			activated.setText("Active  ");
		}
		panel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, border));
		
		activated.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (activated.isSelected()) {
					assign.setActive(true);
					activated.setText("Active  ");
					panel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, active));
				} else {
					
					assign.setActive(false);
					activated.setText("Deactive");
					panel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, deactive));
				}

			}
		});

	

		this.add(panel);
		this.add(activated);
		this.add(edit);
		this.add(close);
		
	}


	void AddEditBtnActionLiistener(ActionListener l){
		edit.addActionListener(l);
	}
	
	void AddClsBtnActionLiistener(ActionListener l){
		close.addActionListener(l);
	}
}
