package frontend;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import shared.Assignment;
import shared.FileObj;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JToggleButton;

public class AssignmentDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private Assignment assign;
	private JLabel label;

	public AssignmentDialog(CoursePage parent) {

		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblTile = new JLabel("Tile");
		panel.add(lblTile, "6, 4");

		textField = new JTextField();
		panel.add(textField, "10, 4, fill, default");
		textField.setColumns(10);

		JLabel lblFile = new JLabel("File");
		panel.add(lblFile, "6, 6");

		label = new JLabel("");
		panel.add(label, "10, 6");

		JButton btnUpload = new JButton("Upload");
		panel.add(btnUpload, "10, 8, center, default");
		JFileChooser chooser = new JFileChooser();
		JDialog dialog = this;
		btnUpload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = chooser.showOpenDialog(dialog);
				if (r == JFileChooser.APPROVE_OPTION) {
					try {
						File file = chooser.getSelectedFile();
						if (file != null) {
							label.setText(file.getName());
							assign.setFile(new FileObj(file));
						} else {
							JOptionPane.showConfirmDialog(dialog, "Invalid file!");
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel lblDueDate = new JLabel("Due Date");
		panel.add(lblDueDate, "6, 10");

		textField_1 = new JTextField();
		panel.add(textField_1, "10, 10, fill, default");
		textField_1.setColumns(10);

		JLabel lblActive = new JLabel("Active");
		panel.add(lblActive, "6, 12");

		JToggleButton toggleButton = new JToggleButton("False");
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
		panel.add(toggleButton, "10, 12, left, default");

		JPanel btns = new JPanel();
		getContentPane().add(btns, BorderLayout.SOUTH);

		JButton btnSave = new JButton("Save");
		btns.add(btnSave);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(assign.getFile() == null) {
					JOptionPane.showMessageDialog(dialog, "Invalid file", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				assign.setTitle(textField.getText());
				assign.setDue_date(textField_1.getText());
				assign.setActive(toggleButton.isSelected());
				parent.addAssignment(assign);
				dialog.setVisible(false);
				dialog.dispose();
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btns.add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dialog.setVisible(false);
				dialog.dispose();
			}
		});

		this.setLocationRelativeTo(null);
		this.setSize(500, 250);
	}

	public void showDialog(String title, Assignment a) {
		if (a != null) {
			textField.setText(a.getTitle());
			textField_1.setText(a.getDue_date());
			if (a.getFile() != null) {
				File file = a.getFile().file;
				label.setText(file.getName());
			}

		} else {
			a = new Assignment(0);
			textField.setText("");
			textField_1.setText("");
		}
		this.assign = a;
		this.setTitle(title);
		this.setVisible(true);

	}
}
