package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import shared.Assignment;
import shared.FileObj;
import shared.Submission;

public class SubmissionPage extends JPanel {

	private JTextField topLabel;
	private JTable submissionTable;
	private Assignment assign;
	private JPanel submissions;
	private Client client;

	public SubmissionPage(Client c) {

		this.client = c;
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);
		this.setBackground(new Color(255, 255, 255));
		topLabel = new JTextField("Assignment:");
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
		this.submissions = new JPanel();
		BoxLayout l = new BoxLayout(submissions, BoxLayout.Y_AXIS);
		submissions.setLayout(l);
		this.add(submissions, BorderLayout.CENTER);
	}

	public void update() {
		submissions.removeAll();
		for (Submission s : assign.getSubmissions()) {
			SubmissionItem item = new SubmissionItem(s);
			submissions.add(item);
			System.out.println("ID" + s.getStudent().id);
			item.addDOcumentListner(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					change();
				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					change();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					change();
				}

				public void change() {
					try {
						if (item.grade2.getText().trim().isEmpty()) {

						} else {
							s.setSubmission_grade(Integer.parseInt(item.grade2.getText()));
							client.updateSubmission(s);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

			item.actionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						downloadAction(s);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}

		this.revalidate();
		this.repaint();
	}

	public void downloadAction(Submission s) throws ClassNotFoundException, IOException {
		FileObj file = client.getFile(s);
		JFileChooser fileDownload = new JFileChooser();

		fileDownload.setSelectedFile(new File(file.file.getName()));
		int r = fileDownload.showSaveDialog(this);

		if (r == JFileChooser.APPROVE_OPTION) {
			try {
				storeFile(fileDownload.getSelectedFile().getAbsolutePath(), file.data);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void storeFile(String filename, byte[] data) throws IOException {
		Files.write(Paths.get(filename), data);
	}

	public void setAssignment(Assignment a) {
		// TODO Auto-generated method stub
		this.assign = a;
		topLabel.setText("Assignment:" + a.getTitle());
		System.out.println("Assignment submissions " + a.getTitle() + " " + a.getSubmissions());
		// model.setData(a.getSubmissions());
		update();
	}

}

// class SubmissionTableModel extends AbstractTableModel{
//
// private List<Submission> data;
// String[] names = new String[] {"ID","First name", "Last name", "File" ,
// "marks"};
//
//
// public SubmissionTableModel() {
// data = new ArrayList<Submission>();
// }
// public void setData(List<Submission> s) {
// data = s;
// System.out.println(data.size());
// fireTableDataChanged();
// }
//
// @Override
// public int getRowCount() {
// // TODO Auto-generated method stub
// return data.size();
// }
//
// @Override
// public int getColumnCount() {
// // TODO Auto-generated method stub
// return names.length;
// }
//
// @Override
// public String getColumnName(int columnIndex) {
// // TODO Auto-generated method stub
// return names[columnIndex];
//
// }
//
// @Override
// public Class<?> getColumnClass(int columnIndex) {
// // TODO Auto-generated method stub
// return null;
// }
//
// @Override
// public boolean isCellEditable(int rowIndex, int columnIndex) {
// // TODO Auto-generated method stub
// if(columnIndex == 4 && rowIndex >0) {
// return true;
// }
// return false;
// }
//
// @Override
// public Object getValueAt(int rowIndex, int columnIndex) {
// // TODO Auto-generated method stub
// Submission cell = data.get(rowIndex);
// if(columnIndex == 0) {
// return cell.getStudent().id;
// }if(columnIndex == 1) {
// return cell.getStudent().getFirstName();
// }
// if(columnIndex == 2) {
// return cell.getStudent().getLastName();
// }
// if(columnIndex == 3) {
// return cell.getPath();
// }
// return null;
// }
//
// @Override
// public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
// // TODO Auto-generated method stub
// if(columnIndex == 4 && rowIndex >0) {
// data.get(rowIndex).setSubmission_grade((Integer) aValue);
// fireTableCellUpdated(rowIndex, columnIndex);
// }
//
// }
//
//
// }