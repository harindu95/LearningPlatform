package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import shared.Assignment;
import shared.Submission;

public class SubmissionPage extends JPanel {
	
	private JTextField topLabel;
	private JTable submissionTable;
	private SubmissionTableModel model;
	private Assignment assign;

	public SubmissionPage(){
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
		this.submissionTable = new JTable();
		this.model = new SubmissionTableModel();
		submissionTable.setModel(model);
	}

	public void setAssignment(Assignment a) {
		// TODO Auto-generated method stub
		this.assign = a;
		topLabel.setText("Assignment:" + a.getTitle());
		model.setData(a.getSubmissions());
	}

}

class SubmissionTableModel extends AbstractTableModel{

	private List<Submission> data;
	String[] names = new String[] {"ID","First name", "Last name", "File" , "marks"};

	
	
	public void setData(List<Submission> s) {
		data = s;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return names[columnIndex];
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex == 4 && rowIndex >0) {
			return true;
		}
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Submission cell = data.get(rowIndex);
		if(columnIndex == 0) {
			return cell.getStudent().id;
		}if(columnIndex == 1) {
			return cell.getStudent().getFirstName();
		}
		if(columnIndex == 2) {
			return cell.getStudent().getLastName();
		}
		if(columnIndex == 3) {
			return cell.getPath();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex == 4 && rowIndex >0) {
			data.get(rowIndex).setSubmission_grade((Integer) aValue);
			 fireTableCellUpdated(rowIndex, columnIndex);
		}
		
	}

	
}