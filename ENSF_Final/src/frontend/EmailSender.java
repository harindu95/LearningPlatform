package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import shared.Email;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class EmailSender extends JFrame {
	private JTextField toField;
	private JTextField subject;
	private JTextField fromField;
	private Client client;
	public ArrayList<String> to;
	private JTextArea textArea;
	
	public EmailSender(Client c) {
		to = new ArrayList<String>();
		this.client = c;
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("1px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "1, 1, fill, top");
		panel.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
		
		JLabel lblTo = new JLabel("To");
		getContentPane().add(lblTo, "3, 3");
		
		toField = new JTextField();
		getContentPane().add(toField, "6, 3, fill, default");
		toField.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		getContentPane().add(lblSubject, "3, 5");
		
		subject = new JTextField();
		getContentPane().add(subject, "6, 5, fill, default");
		subject.setColumns(10);
		
		JLabel lblFrom = new JLabel("From");
		getContentPane().add(lblFrom, "3, 7");
		
		fromField = new JTextField();
		getContentPane().add(fromField, "6, 7, fill, default");
		fromField.setColumns(10);
		
		JLabel lblMeesage = new JLabel("Message");
		getContentPane().add(lblMeesage, "3, 9");
		
		this.textArea = new JTextArea();
		getContentPane().add(textArea, "6, 9, fill, fill");
		
		JButton btnSend = new JButton("Send");
		JFrame frame = this;
		btnSend.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Email email = new Email();
						email.content = textArea.getText();
						email.from = fromField.getText();
						email.to = new String[to.size()];
						email.to = to.toArray(email.to);
						email.subject = subject.getText();
						email.reciever = toField.getText();
						try {
							client.sendEmail(email);
							frame.setVisible(false);
							frame.dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				});
		getContentPane().add(btnSend, "6, 11, center, default");
	}
	

	public void addReciever(String a) {
		to.add(a);
	}
	
	public void showWindow(String sender, String reciever) {
		
		this.toField.setText(reciever);
		this.subject.setText("");
		this.fromField.setText(sender);
		this.textArea.setText("");
		this.setSize(700, 700);
		this.setVisible(true);
		
	}
}
