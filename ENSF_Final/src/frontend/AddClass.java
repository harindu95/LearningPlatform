package frontend;

import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddClass extends JDialog {
	private JTextField textField;
	private boolean enabled;
	
	public AddClass() {
		super((JFrame)null,"Add class");
//		this.setUndecorated(true);
		this.setResizable(false);
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(null);
		this.setSize(704,505);
		this.enabled = true;
		JLabel label = new JLabel("");
		label.setBounds(27, 170, 608, 141);
		getContentPane().add(label);
		
		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblCancel.setIcon(new ImageIcon(AddClass.class.getResource("/images/cancel_crs_btn2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblCancel.setIcon(new ImageIcon(AddClass.class.getResource("/images/cancel_crs_btn1.png")));
			}
		});
		lblCancel.setIcon(new ImageIcon(AddClass.class.getResource("/images/cancel_crs_btn1.png")));
		lblCancel.setBounds(207, 423, 147, 46);
		getContentPane().add(lblCancel);
		
		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblAddCourse.setIcon(new ImageIcon(AddClass.class.getResource("/images/Add_crs_btn2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblAddCourse.setIcon(new ImageIcon(AddClass.class.getResource("/images/Add_crs_btn1.png")));
			}
		});
		lblAddCourse.setIcon(new ImageIcon(AddClass.class.getResource("/images/Add_crs_btn1.png")));
		lblAddCourse.setBounds(27, 423, 147, 46);
		getContentPane().add(lblAddCourse);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				enabled = !enabled;
				if(enabled) {
					label_1.setIcon(new ImageIcon(AddClass.class.getResource("/images/on.png")));
				}else {
					label_1.setIcon(new ImageIcon(AddClass.class.getResource("/images/off.png")));
				}
			}
		});
		label_1.setIcon(new ImageIcon(AddClass.class.getResource("/images/on.png")));
		label_1.setBounds(554, 346, 91, 38);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				label_2.setIcon(new ImageIcon(AddClass.class.getResource("/images/open_image1.png")));
				JFileChooser chooser = new JFileChooser();
				int r  = chooser.showOpenDialog(label_1);;
				if(r == JFileChooser.APPROVE_OPTION) {
					label.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_2.setIcon(new ImageIcon(AddClass.class.getResource("/images/open_image2.png")));
			}
		});
		label_2.setIcon(new ImageIcon(AddClass.class.getResource("/images/open_image1.png")));
		label_2.setBounds(27, 346, 130, 32);
		getContentPane().add(label_2);
		
		textField = new JTextField("Name");
		textField.setBackground(new Color(249, 242, 242));
		textField.setBorder(null);
		textField.setBounds(27, 107, 591, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
//		name.setBounds(580,20,25,106);
		JLabel background = new JLabel("");
		background.setSize(704,491);
		background.setIcon(new ImageIcon(AddClass.class.getResource("/images/add_course.png")));
		panel.add(background);
		
	}

	public static void main(String[] args) {
		AddClass k = new AddClass();
		k.setVisible(true);
//		JDialog d = new JDialog((JFrame)null, "hello");
//		d.setVisible(true);
	}
}
