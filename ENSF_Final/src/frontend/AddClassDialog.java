package frontend;

import javax.swing.JDialog;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import shared.Course;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddClassDialog extends JDialog {

	CoursesPage parent = null;
	private JTextField textField;
	Course course = null;

	AddClassDialog(CoursesPage parent) {
		super();
		this.setTitle("Add Course");

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(12, 27, 207, 14);
		getContentPane().add(lblNewLabel);
		
		
		
		textField = new JTextField();
		textField.setBounds(135, 18, 212, 34);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(36, 115, 117, 25);
		getContentPane().add(btnAdd);
		JDialog dialog = this;


		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(246, 115, 117, 25);
//		JOptionPane.showConfirmDialog(parentComponent, message)
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				course = null;
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		getContentPane().add(btnCancel);
		
		JLabel lblEnabled = new JLabel("Enabled");
		lblEnabled.setBounds(12, 74, 70, 15);
		getContentPane().add(lblEnabled);
		
		JToggleButton toggleButton = new JToggleButton("True");
		toggleButton.setBounds(135, 64, 167, 25);
		toggleButton.setSelected(true);
		toggleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (toggleButton.isSelected()) {
					toggleButton.setText("True");
				} else {
					toggleButton.setText("False");
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				course = new Course(textField.getText());
				course.setActive(toggleButton.isSelected());
				parent.addCourse(course);
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		getContentPane().add(toggleButton);
		this.setLocationRelativeTo(null);
		this.setSize(400,200);
	}

	void showDialog() {

		this.course = null;
		this.textField.setText("");
		JDialog dialog = this;
		dialog.setVisible(true);

	}
}
